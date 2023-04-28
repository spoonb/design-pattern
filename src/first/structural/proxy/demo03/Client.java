package first.structural.proxy.demo03;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Downloader downloader = new ProxyBiliBiliDownloader();
        downloader.download("/root/home/buzuweiqi/java_manual.txt");
        downloader = new ProxyYoutubeDownloader();
        downloader.download("/root/home/buzuweiqi/linux_manual.txt");
    }
}