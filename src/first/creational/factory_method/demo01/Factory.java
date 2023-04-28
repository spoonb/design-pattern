package first.creational.factory_method.demo01;

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