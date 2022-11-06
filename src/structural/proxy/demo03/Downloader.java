package structural.proxy.demo03;

public interface Downloader {
    byte[] download(String filePath) throws InterruptedException;
}