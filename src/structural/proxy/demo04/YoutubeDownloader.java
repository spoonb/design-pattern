package structural.proxy.demo04;

public class YoutubeDownloader implements Downloader {
    public byte[] download(String filePath) throws InterruptedException {
        System.out.printf("正在下载Youtube文件：%s%n", filePath);
        // 模拟文件下载，睡个10秒
        Thread.sleep(10000);
        return new byte[1024]; // 假装是下载文件的字节数组
    }
}