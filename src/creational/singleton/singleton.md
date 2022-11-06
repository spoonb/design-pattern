## 简述

杜绝相同对象的反复创建，提升系统性能。

话不多说，直接看实现方案例。

## 实现案例

### 饿汉式

**项目启动时加载**

```java
public class Test {
    private static Test ins = new Test();
    public static Test instance() {
        return ins;
    }
}
```

在项目启动时就被加载 → 项目启动变慢
如果对象不经常使用的话还存在浪费资源的问题。

### 懒汉式

**懒加载，在使用时才被加载**

```java
public class Test {
    private static Test ins;

    public static synchronized Test instance() {
        if (ins == null) ins = new Test();
        return ins;
    }
}
```

在项目启动时并不加载 → 项目加载变快
第一次使用时加载 → 存在第一次使用时等待过长的问题
使用synchronized方法 → 性能下降

### 懒汉式(优化版)

**懒加载，在使用时才被加载(解决并发的性能问题)**

```java
public class Test {
    private static Test ins;

    public static Test instance() {
        if (ins == null) {
            synchronized (Test.class) {
                if (ins == null) ins = new Test();
            }
        }
        return ins;
    }
}
```

在项目启动时并不加载 → 项目加载变快
第一次使用时加载 → 存在第一次使用时等待过长的问题
使用双重判断方法 → 相对优化前性能提升
**不推荐使用**

### 静态内部类(懒汉式)

**懒加载，在使用时才会被加载(无并发性能问题)**

```java
public class Test {
    private static class Singleton {
        private static final Test ins = new Test();
    }

    public static Test instance() {
        return Singleton.ins;
    }
}
```

在项目启动时并不加载 → 项目加载变快
第一次使用时加载 → 存在第一次使用时等待过长的问题
**推荐使用**

### 枚举(饿汉式)

```java
public enum Test {
    INSTANCE;

    public static Test instance() {
        return INSTANCE;
    }
}
```

在项目启动时就被加载 → 项目启动变慢
如果对象不经常使用的话还存在浪费资源的问题。
**推荐使用**

## 总结

### 优点

1. 减少对象的创建次数，提高系统性能。

### 缺点

1. 由于是静态资源，所以增加了内存上的负担。

### 适用场景

1. 避免资源的互斥(见样例)

   ```java
   public class Test {
       private FileWriter fw;

       public void write(String fileName, String data) throws IOException {
           fw = new FileWriter(fileName);
           fw.write(data);
       }
   }
   ```

   这段代码可能会有问题：当多个Test对象对同一个fileName写入时，由于FileWriter的父类Writer中定义的write有一把对象锁，多个FileWriter就导致有多把锁，无法做到互斥，就会出现错误。

2. 全局唯一类(工具类等)