## 简述

定义一个用于创建某一对象的接口，并将实际的创建实现延迟到子类。

话不多说，看个优化案例。

## 优化案例

### 最初版v0(简单工厂)

```java
public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = Factory.uploader("LinuxUploader");
    }
}

// 简单工厂
public class Factory {
    static Uploader uploader(String target) throws Exception {
        if ("LinuxUploader".equals(target)) {
            return new LinuxUploader();
        } else if ("UnixUploader".equals(target)) {
            return new UnixUploader();
        } 
        throw new Exception("输入的参数错误");
    }
}

// 上传模块的接口
public interface Uploader {
    void upload(String fileName);
}

// Linux环境下的上传实现
public class LinuxUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Linux]正在上传%s...", fileName);
    }
}

// Unix环境下的上传实现
public class UnixUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Unix]正在上传%s...", fileName);
    }
}
```

虽然简单工厂模式可以统一管理对象的创建，但是由于没有继承或者实现的结构所以在需要使用多态的时候简单工厂就会变得很鸡肋。

为了解决这个问题，我们引入了工厂方法模式。

### 修改版v1

```java
public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = uploader(new LinuxFactory());
        Uploader uploader1 = uploader(new UnixFactory());
        System.out.println(uploader);
        System.out.println(uploader1);
    }

    public static Uploader uploader(Factory factory) {
        return factory.uploader();
    }
}

// 工厂方法
public interface Factory {
    Uploader uploader();
}

public class LinuxFactory implements Factory {
    @Override
    public Uploader uploader() {
        return new LinuxUploader();
    }
}

// Linux环境下的上传实现
public class LinuxUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Linux]正在上传%s...", fileName);
    }
}

public class UnixFactory implements Factory {
    @Override
    public Uploader uploader() {
        return new UnixUploader();
    }
}

// Unix环境下的上传实现
public class UnixUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Unix]正在上传%s...", fileName);
    }
}

// 上传模块的接口
public interface Uploader {
    void upload(String fileName);
}
```

根据传入uploader的参数不同，返回的Uploader对象也不同，这会使得开发时对象的创建更加的灵活。

## 总结

### 优点

- 不仅有着类似简单工厂模式的统一管理对象创建的功能，而且由于有着继承或者实现的特征使得工厂方法模式有着更广的应用场景。

### 缺点

- 增加了类的数量，或许会在一定程度上使得系统复杂化。

### 适用场景

- 需要统一管理对象创建并且需要用到多态的场景。