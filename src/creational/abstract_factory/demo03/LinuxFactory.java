package creational.abstract_factory.demo03;

// Linux环境下的工厂实现
public class LinuxFactory implements Factory {
    public Uploader uploader() {
        return new LinuxUploader();
    }
    
    public Downloader downloader() {
        return new LinuxDownloader();
    }
}