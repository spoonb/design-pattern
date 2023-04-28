package first.creational.abstract_factory.demo02;

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