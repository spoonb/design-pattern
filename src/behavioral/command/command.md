## 简述

软件开发中，通常**行为请求者**和**行为实现者**呈现紧耦合。但在某种情况下，需要对行为进行诸如"记录，撤销/重做、事物"等处理，紧耦合的结构显然是无法满足这种复杂的变化的。为此，需要将**行为请求者**和**行为实现者**解耦。这就是**命令模式**。

**举个例子**

> 类似空调的运行原理。
> 当我们点击遥控器上的各种按钮时，并不是遥控器来负责制冷、制热，而是仅仅将各种指令发送给了空调的主机由主机实现各种命令的功能。

就这样的感觉，哈哈。话不多说，看个使用命令模式的优化案例。

## 优化案例

现在，我们有多台服务器对应着各种不同的环境(开发，测试，生产)。现在有个临时的工作需要我们将最新的资源(代码等)同时发布到好几个不同的环境中。最初，我们采用了以下传统的方式。

### 最初版v0

```java
// 客户端
public class Client {

    private static List<Server> servers  = new ArrayList<>();

    public static void main(String[] args) {
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        for (Server app : servers) {
            app.upload();
            app.release();
        }
    }
}

// 服务器
public class Server {
    private String ip;
    private String domain;

    public Server(String ip, String domain) {
        this.ip = ip;
        this.domain = domain;
    }

    public void upload() {
        System.out.printf("资源上传 --> %s[%s]\n", this.domain, this.ip);
    }

    public void test() {
        System.out.printf("资源测试 --> %s[%s]\n", this.domain, this.ip);
    }

    public void release() {
        System.out.printf("资源发布 --> %s[%s]\n", this.domain, this.ip);
    }
}
```

确实我们实现了需求，但是我们行为的请求者和实现者是同一个，并且还是客户端。这无疑对于后期的维护来说是个隐患。

**举个例子**

> 比如我们需要在release之前测试下当前的资源是否可以正常运行，显然我们得在客户端里增加启动测试功能的逻辑。随着这类需求的增加，客户端将越来越庞大。

为此，我们得将命令的发布者和执行者分开，这就要使用到命令模式了。

### 修改版v1

```java
public class Client {

    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        // 组装所有需要执行的命令
        Manager man = new Manager();
        man.addCmd(new Upload(servers));
        man.addCmd(new Test(servers));
        man.addCmd(new Release(servers));

        // 发送命令
        man.invokeCmd();
    }
}

// receiver
public class Server {
    private String ip;
    private String domain;

    public Server(String ip, String domain) {
        this.ip = ip;
        this.domain = domain;
    }

    public void upload() {
        System.out.printf("资源上传 --> %s[%s]\n", this.domain, this.ip);
    }

    public void test() {
        System.out.printf("资源测试 --> %s[%s]\n", this.domain, this.ip);
    }

    public void release() {
        System.out.printf("资源发布 --> %s[%s]\n", this.domain, this.ip);
    }
}

// invoker
public class Manager {
    private List<Command> cmds = new ArrayList<>();

    public void addCmd(Command cmd) {
        cmds.add(cmd);
    }

    public void invokeCmd() {
        for (Command cmd : cmds) {
            cmd.execute();
        }
    }
}

public abstract class Command {

    protected List<Server> servers = new ArrayList<>();

    public Command(Server app) {
        this.servers.add(app);
    }

    public Command(List<Server> apps) {
        this.servers = apps;
    }

    public abstract void execute();
}

public class Upload extends Command {
    public Upload(Server server) {
        super(server);
    }

    public Upload(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====upload start=====");
        for (Server server : servers) {
            server.upload();
        }
        System.out.println("=====upload end=====");
    }
}

public class Test extends Command {
    public Test(Server server) {
        super(server);
    }

    public Test(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====Test start=====");
        for (Server app : servers) {
            app.test();
        }
        System.out.println("=====Test end=====");
    }
}

public class Release extends Command {
    public Release(Server server) {
        super(server);
    }

    public Release(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====release start=====");
        for (Server app : servers) {
            app.release();
        }
        System.out.println("=====release end=====");
    }
}
```

将行为请求者和行为实现者解耦，但是好想依旧有个问题没有解决：我们具体的请求依旧写死在客户端，如果请求有变化时，我们依旧需要修改客户端。不要着急，这个问题可以通过java的反射机制解决。看下面一段代码吧。

### 修改版v2

只修改了客户端的代码，并相应增加了一个配置文件。

```java
public class Client {

    public static void main(String[] args) throws Exception {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        // 组装所有需要执行的命令，可以通过反射配置在文件里
        BufferedReader br = new BufferedReader(new FileReader("src/behavioral/command/demo03/resource/cmds"));
        Manager man = new Manager();
        String s = null;
        while ((s = br.readLine()) != null) {
            man.addCmd((Command) Class.forName(s).getDeclaredConstructor(List.class).newInstance(servers));
        }
        br.close();

        // 发送命令
        man.invokeCmd();
    }
}
```

配置文件cmds.txt

```txt
behavioral.command.demo03.Upload
behavioral.command.demo03.Test
behavioral.command.demo03.Release
```

通过反射读取配置文件创建相应的command对象，这样就不需要修改代码了，每次执行的命令有变化时，只需要修改配置文件即可。

## 总结

### 优点

- 将行为请求者与行为实现者解耦。
- 配合java反射可以做到不违反开闭原则更改需要执行的命令。

### 缺点

- 增加了大量的类（command，invoke，receiver等），增加了系统的复杂度。
- 大量适用命令模式的话，对于开发人员的要求会很高(工资也就高了)，从而增加项目维护成本。

### 适用场景

- 当需要操作的记录、支持撤销/重做、事务的时候，可以考虑。
