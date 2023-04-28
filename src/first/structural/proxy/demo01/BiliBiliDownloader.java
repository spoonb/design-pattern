package first.structural.proxy.demo01;

public class BiliBiliDownloader {
    public byte[] download(String filePath) throws InterruptedException {
        System.out.printf("正在下载BiliBili文件：%s%n", filePath);
        // 模拟文件下载，睡个10秒
        Thread.sleep(10000);
        return new byte[1024]; // 假装是下载文件的字节数组
    }
}
