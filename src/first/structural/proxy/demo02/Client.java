package first.structural.proxy.demo02;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BiliBiliDownloader downloader = new BiliBiliDownloader();
        downloader.download("/root/home/buzuweiqi/java_manual.txt");
        // 由于文件已经缓存，所以这次下载非常快
        downloader.download("/root/home/buzuweiqi/java_manual.txt");
        // 由于文件还未缓存，所以这次下载比较缓慢
        downloader.download("/root/home/buzuweiqi/linux_manual.txt");
    }
}