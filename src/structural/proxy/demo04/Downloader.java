package structural.proxy.demo04;

public interface Downloader {
    byte[] download(String filePath) throws InterruptedException;
}