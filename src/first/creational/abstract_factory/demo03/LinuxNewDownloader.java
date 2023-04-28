package first.creational.abstract_factory.demo03;

// Linux环境下的下载实现
public class LinuxNewDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Linux]正在下载%s...", fileName);
    }
}