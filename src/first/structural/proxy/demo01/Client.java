package first.structural.proxy.demo01;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        BiliBiliDownloader bilidownloader = new BiliBiliDownloader();
        bilidownloader.download("/root/buzuweiqi/java_manual.txt");
    }
}