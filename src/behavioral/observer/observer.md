## 简述

对象的状态(属性的值)发生变化时，向指定(所有)监听(观察)类广播。

> **举个例子**
> B站我关注了一个up主，每次这个up主更新动态时我都会随之收到一条推送消息。并且这条消息不止我一个人收到，所以关注了该up主的用户都会收到这条消息。说是说观察者模式，意为观察目标对象的状态变化。实际上从代码实现的角度来看更像是**目标对象的状态发生变化后自发的通知指定(所有)的观察者类**。

话不多说，看个优化案例吧。

## 优化案例

现在我们有个服务器需要监听其性能。

### 最初版v0

```java
// 客户端
public class Client {

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
        monitor(server);
        for (int i = 0; i < 4; i ++) {
            server.startASoft();
            monitor(server);
        }
        server.stopASoft();
        monitor(server);
    }

    // server的所有参数都在客户端中监听, 随着开发的不断进行, 客户端会越发臃肿且难以维护
    public static void monitor(Server server) {
        if (server.getCpu() >= 85)
            System.out.printf("警告, cpu使用率 --> %s%%\n", server.getCpu());
        if (server.getMemory() >= 90)
            System.out.printf("警告, 内存使用率 --> %s%%\n", server.getMemory());
        if (server.getDisk() >= 95)
            System.out.printf("警告, 硬盘使用率 --> %s%%\n", server.getDisk());
        if (server.getGpu() >= 85)
            System.out.printf("警告, gpu使用率 --> %s%%\n", server.getGpu());
    }
}

// 服务器
public class Server {

    private double cpu;
    private double memory;
    private double disk;
    private double gpu;

    public void startServer() {
        this.cpu = 15;
        this.memory = 20;
        this.disk = 10;
        this.gpu = 5;
    }

    public void startASoft() {
        this.cpu += 15;
        this.memory += 20;
        this.disk += 10;
        this.gpu += 15;
    }

    public void stopASoft() {
        this.cpu -= 15;
        this.memory -= 20;
        this.disk -= 10;
        this.gpu -= 15;
    }

    public double getCpu() {
        return cpu;
    }

    public double getMemory() {
        return memory;
    }

    public double getDisk() {
        return disk;
    }

    public double getGpu() {
        return gpu;
    }
}
```

目前的实现有两个问题。

1. 监听的实现写在了客户端，客户端应该只有简单的业务代码，不应该涉及复杂的逻辑和业务。
2. 每次监听都是所有资源同时监听，这无疑会消耗性能。存在只需要监听其中的一个或者几个资源而不是全部的情况。

为了解决以上问题，我们引入观察者模式。

### 修改版v1

```java
// 客户端
public class Client {

    public static void main(String[] args) {
        Server server = new Server();
        server.addOb(new CPUObserver(server));
        server.addOb(new MemoryObserver(server));
        server.addOb(new DiskObserver(server));
        server.addOb(new GPUObserver(server));

        // 将每种不同参数的监听教给不同的观察者, 而不是定义在客户端中
        server.startServer();
        for (int i = 0; i < 4; i ++) {
            server.startASoft();
        }
        server.stopASoft();
    }
}

// 服务器
public class Server {

    private double cpu;
    private double memory;
    private double disk;
    private double gpu;

    private List<Observer> obs = new ArrayList<>();

    public void startServer() {
        this.cpu = 15;
        this.memory = 20;
        this.disk = 10;
        this.gpu = 5;
        update();
    }

    public void startASoft() {
        this.cpu += 15;
        this.memory += 20;
        this.disk += 10;
        this.gpu += 15;
        update();
    }

    public void stopASoft() {
        this.cpu -= 15;
        this.memory -= 20;
        this.disk -= 10;
        this.gpu -= 15;
        update();
    }

    public void addOb(Observer ob) {
        obs.add(ob);
    }

    private void update() {
        for (Observer ob : obs) {
            ob.update();
        }
    }

    public double getCpu() {
        return cpu;
    }

    public double getMemory() {
        return memory;
    }

    public double getDisk() {
        return disk;
    }

    public double getGpu() {
        return gpu;
    }
}

// 观察这接口
public interface Observer {
    void update();
}

public class CPUObserver implements Observer {

    private Server server;

    public CPUObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getCpu() >= 85)
            System.out.printf("警告, cpu使用率 --> %s%%\n", server.getCpu());
    }
}

public class DiskObserver implements Observer {

    private Server server;

    public DiskObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getDisk() >= 95)
            System.out.printf("警告, 硬盘使用率 --> %s%%\n", server.getDisk());
    }
}

public class GPUObserver implements Observer {

    private Server server;

    public GPUObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getGpu() >= 85)
            System.out.printf("警告, gpu使用率 --> %s%%\n", server.getGpu());
    }
}

public class MemoryObserver implements Observer {

    private Server server;

    public MemoryObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getMemory() >= 90)
            System.out.printf("警告, 内存使用率 --> %s%%\n", server.getMemory());
    }
}
```

从客户端代码中我们可以看出，可以对于我们指定的资源进行监听，并且监听的逻辑已经从客户端剥离。并且对于新的监听方式，我们只需要新增一个`Observer`的实现类即可，方便快捷，拓展性强。

## 总结

### 优点

- 无需修改原有模块即可增加新的观察者类。

- 可在运行时建立对象间关系，使得对象间关系设定更加灵活。

  > **运行时建立对象间关系**
  > 运行时才set当前对象中所持有的一个对象的实例。
  >
  > **定义时建立对象间关系**
  > `public Instance instance = new Instance()`诸如这样的写法，在运行时无法改变当前对象中持有的其它对象的情况。

### 缺点

- 除了适用场景不是非常广，其实也没有啥明显的缺点。

### 适用场景

- 发布订阅模型，如上文举出的B站的例子。
- 事件监听模型，如云服务器中的各种系统参数监听(cpu、内存等)。