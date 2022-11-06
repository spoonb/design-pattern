## 简述

- 类型：结构型
- 目的：为子系统的一组接口**提供统一的入口**，定义了一个高层接口封装底层接口以**提升系统的易用性**。

废话不多说，直接看案例。

## 优化案例

### 最初版v0

我们都知道，网购有以下几个角色与阶段。

```java
public class Customer {
    public void start() {
        System.out.println("下单。。。");
    }
    public void end() {
        System.out.println("收件。。。");
        System.out.println("付款。。。");
    }
}

public class Shop {
    public void accpet() {
        System.out.println("确认订单。。。");
    }
}

public class Logistics {
    public void send() {
        System.out.println("发出包裹。。。");
    }
}
```

我们来看看传统写法怎么实现购买流程。

```java
public class Taobao {
    private static Customer customer = new Customer();
    private static Shop shop = new Shop();
    private static Logistics logistics = new Logistics();
    public static void main(String[] args) {
        customer.start();
        shop.accpet();
        logistics.send();
        customer.end();
    }
}
```

可以看出传统的实现方法代码量还是比较多的。而且客户端对于服务端的细节知道的太多，耦合度高。想要让客户端与服务端竟可能的降低耦合度，比较好的办法就是增加一个门面类，将上述流程打包到门面类中，客户端只需要调用门面类就可以了。

我们来看看如何使用门面模式优化实现。

### 修改版v1

```java
public class Customer {
    public void start() {
        System.out.println("下单。。。");
    }
    public void end() {
        System.out.println("收件。。。");
        System.out.println("付款。。。");
    }
}

public class Shop {
    public void accpet() {
        System.out.println("确认订单。。。");
    }
}

public class Logistics {
    public void send() {
        System.out.println("发出包裹。。。");
    }
}

public class Facade {
    private Customer customer = new Customer();
    private Shop shop = new Shop();
    private Logistics logistics = new Logistics();
    public void flow() {
        customer.start();
        shop.accpet();
        logistics.send();
        customer.end();
    }
}
```

我们再看看客户端代码。

```java
public class Taobao {
    private static Facade facade = new Facade();
    public static void main(String[] args) {
        facade.flow();
    }
}
```

使用方便，简洁明了。并且当业务有变更时，客户端代码依旧不变，只需要适当的修改服务端代码就OK了。

## 总结

### 优点

1. 从依赖各个低层接口到依赖高层接口，降低了各个模块间的耦合度，提升了开发效率。
2. 当业务细节有所改变时，不需要修改客户端的代码。

### 缺点

1. 业务细节改变时，存在修改门面类的可能性，从服务端角度看不符合开闭原则。※但从客户端角度看又符合开闭原则。

### 适用场景

1. 业务流程固定的代码的优化。如，多个服务的开启与关闭。