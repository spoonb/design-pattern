package first.creational.abstract_factory.demo01;

public class Client {
    public static void main(String[] args) {
        Uploader uploader = new LinuxUploader();
        // Downloader downloader = new LinuxDownloader(); // 当对象废弃时，需要把系统中所有的对象都修改为新的对象
        Downloader downloader = new LinuxNewDownloader();
    }
}
