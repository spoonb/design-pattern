package creational.simple_factory.demo02;

public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = Factory.uploader("LinuxUploader");
        // Downloader downloader = Factory.downloader("LinuxDownloader");
        // 当对象废弃时，只需要把Factory中的LinuxDownLoader → LinuxNewDownLoader即可
        Downloader downloader = Factory.downloader("LinuxDownloader");
    }
}
