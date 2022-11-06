## 简述

将对象的创建封装在工厂类中统一管理，当需要全项目更变某一个对象时，只需要修改工厂类相应方法返回的对象即可，较少了工作量。

话不多说，看个优化案例。

## 优化案例

### 最初版v0

```java
public class Client {
    public static void main(String[] args) {
        Uploader uploader = new LinuxUploader();
        // Downloader downloader = new LinuxDownloader(); // 当对象废弃时，需要把系统中所有的对象都修改为新的对象
        Downloader downloader = new LinuxNewDownloader();
    }
}

// 下载模块的接口
public interface Downloader {
    void download(String fileName);
}

// Linux环境下的下载实现
@Deprecated
public class LinuxDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Linux]正在下载%s...", fileName);
    }
}

// Linux环境下的下载实现
public class LinuxNewDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Linux]正在下载%s...", fileName);
    }
}

// Linux环境下的上传实现
public class LinuxUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Linux]正在上传%s...", fileName);
    }
}

// Unix环境下的下载实现
public class UnixDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Unix]正在下载%s...", fileName);
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

当LinuxDownloader类废弃时，项目中所有的LinuxDownloader对象都要被修改，影响范围太大。

### 修改版v1

增加一个Factory类，并修改Client的对象创建。

```java
public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = Factory.uploader("LinuxUploader");
        // Downloader downloader = Factory.downloader("LinuxDownloader");
        // 当对象废弃时，只需要把Factory中的LinuxDownLoader → LinuxNewDownLoader即可
        Downloader downloader = Factory.downloader("LinuxDownloader");
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
    
    static Downloader downloader(String target) throws Exception {
        if ("LinuxDownloader".equals(target)) {
            return new LinuxNewDownloader(); // new LinuxDownloader();
        } else if ("UnixDownloader".equals(target)) {
            return new UnixDownloader();
        }
        throw new Exception("输入的参数错误");
    }
}
```

如果项目一开始就使用工厂类来创建对象的话，类废弃后只需要把工厂类中废弃的类改为最创建的类即可，非常的方便，实现也很简单，也非常容易理解。

## 总结

### 优点

- 统一管理对象的创建，减少因为对象的更改而展开的大范围修改。

### 缺点

- 随着工厂类管理的对象越来越多，工厂类也越加重量级，尤其是静态工厂。
- 系统对象变更时虽然不需要修改客户端，但是需要修改工厂类，一定程度上破坏了开闭原则。

### 适用场景

- 任何想要统一管理类的创建时，都可以尝试使用。