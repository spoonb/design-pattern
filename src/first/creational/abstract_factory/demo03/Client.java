package first.creational.abstract_factory.demo03;

public class Client {
    private static Factory factory = new LinuxFactory();
    
    public static void main(String[] args) {
        Uploader uploader = factory.uploader();
        Downloader downloader = factory.downloader();
    }
}