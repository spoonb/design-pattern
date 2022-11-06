package creational.abstract_factory.demo04;

// Uinx环境下的工厂实现
public class UnixFactory implements Factory {
    public Uploader uploader() {
        return new UnixUploader();
    }
    
    public Downloader downloader() {
        return new UnixDownloader();
    }
}