package creational.abstract_factory.demo03;

// Unix环境下的下载实现
public class UnixDownloader implements Downloader {
    public void download(String fileName) {
        System.out.printf("[Unix]正在下载%s...", fileName);
    }
}