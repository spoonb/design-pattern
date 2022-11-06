## 简述

大量的对象需要建立通信时，不在是`A <-> B`而是使用`A <-> M <-> B`，即所有相关对象的通信都经过M，降低耦合。

> **A <-> B**
> A类中持有一个B类的对象，使得A可以与B通信。但这样存在一个问题，如当需要让A与C间建立通信关系时，我们只有修改A类的定义，使其新增持有一个C类的对象。因为修改了原有的模块不仅使得原有模块变得复杂，而且还得重新测试原有的模块，增加了开发的成本。并且这种结构会随着需求的不断变更系统的复杂度也随之越来越高。
>
> **A <-> M <-> B**
> A类中持有一个中介者M类，而M持有B类的对象，即便以后需要让A与C间建立通信关系，也不需要修改A类，只需要在M中增持C类对象即可，具体实现可以在M中定义一个A、B、C的上层接口或者抽象类的集合。总之，实现方式很多，根据具体需求取舍即可。

话不多说，看一个优化案例。

## 优化案例

### 最初版v0

```java
public class Client {

    // 可以看出不使用中介者设计模式时，需要在客户端控制用户对象间的通信，这很麻烦
    public static void main(String[] args) {
        User zs = new User("张三", "男", 25);
        User ls = new User("李四", "男", 28);
        User we = new User("王二", "男", 27);
        User zl = new User("赵六", "男", 21);
        User zy = new User("只因", "男", 15);

        // 模拟用户间发消息
        zs.send(ls, "暗号？");
        ls.send(zs, "鸡你太美？");
        zs.send(we, "暗号？");
        we.send(zs, "只因你太美。");
        zs.send(zl, "暗号？");
        zl.send(zs, "基尼太美");
        zs.send(zy, "暗号？");
        zy.send(zs, "我是坤坤！");
    }
}

public class User {
    private String name;
    private String sex;
    private int age;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void send(User target, String msg) {
        System.out.printf("%s接收消息 --> %s\n", target.getName(), msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

对象间的访问、依赖都写在了客户端，并且对于当前对象可以与哪些对象相互通信没有明确的限制，因为User依赖的通信类型还是User。为了解决这个问题，我们可以使用中介者模式，使得所有的User都只与中介者对象通信，并且通过中介者对象持有User的List来限制通信的范围。

### 修改版v1

```java
public class Client {

    public static void main(String[] args) {
        User zs = new User("张三", "男", 25);
        User ls = new User("李四", "男", 28);
        User we = new User("王二", "男", 27);
        User zl = new User("赵六", "男", 21);
        User zy = new User("只因", "男", 15);

        // 创建群组
        List<User> users = new ArrayList<>();
        users.add(zs);
        users.add(ls);
        users.add(we);
        users.add(zl);
        users.add(zy);
        zs.register("ikun", users);

        System.out.println("=====张三发消息开始=====");
        zs.send("ikun", "暗号？");
        System.out.println("=====张三发消息结束=====");

        System.out.println("=====李四发消息开始=====");
        ls.send("ikun", "基尼太美");
        System.out.println("=====李四发消息结束=====");

        System.out.println("=====只因发消息开始=====");
        zy.send("ikun", "我就是坤坤");
        System.out.println("=====只因发消息结束=====");
    }
}

public class User {
    private String name;
    private String sex;
    private int age;

    private Map<String, ChatMediator> chatMap = new HashMap<>();

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void send(String chat, String msg) {
        chatMap.get(chat).sendMsg(msg);
    }

    public void receive(String msg) {
        System.out.printf("%s接收消息 <-- %s\n", name, msg);
    }

    // 注册群聊
    public void register(String name, List<User> users) {
        chatMap.put(name, new GroupChat());
        addUsers(name, users);
    }

    public void addUsers(String name, List<User> users) {
        if (chatMap.containsKey(name)) {
            ChatMediator chatMediator = chatMap.get(name);
            for (User user : users) {
                chatMediator.register(user);
                user.chatMap.put(name, chatMediator);
            }
            return;
        }
        throw new RuntimeException("不存在此群组，请先创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public interface ChatMediator {
    void register(User user);
    void sendMsg(String msg);
}

/**
 * 群聊
 */
public class GroupChat implements ChatMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void register(User user) {
        users.add(user);
    }

    @Override
    public void sendMsg(String msg) {
        for (User user : users) {
            user.receive(msg);
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
```

修改后的模块，User只与GroupChat交互，解决了User间混乱的依赖关系。实现很简单，就不多说了，总结下吧。

## 总结

### 优点

- 适当使用中介者模式可以降低类间的耦合关系。
- 由于各个类只与中介者类通信，类间关系很自然的从原本的1对N转为1对1，易于理解与维护。

### 缺点

- 随着开发的不断进行，中介者类存在慢慢转化为**上帝类**的风险

  > **上帝类**
  > 什么职责都有，什么都能做，万能的类。ps：这显然不是我们想要的。

### 适用场景

- 系统类间关系过于错综复杂，结构混乱时。