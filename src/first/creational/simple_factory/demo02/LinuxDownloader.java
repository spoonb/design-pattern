package first.creational.simple_factory.demo02;

// Linux环境下的下载实现
@Deprecated
public class LinuxDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Linux]正在下载%s...", fileName);
    }
}