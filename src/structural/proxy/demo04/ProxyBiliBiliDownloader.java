package structural.proxy.demo04;

import java.util.HashMap;
import java.util.Map;

public class ProxyBiliBiliDownloader implements Downloader {
    private static Map<String, byte[]> map = new HashMap<>();
    private BiliBiliDownloader downloader = new BiliBiliDownloader();
    public byte[] download(String filePath) throws InterruptedException {
        if (map.containsKey(filePath)) {
            System.out.printf("正在下载BiliBili文件：%s%n", filePath);
            return map.get(filePath);
        }
        byte[] res = downloader.download(filePath);
        map.put(filePath, res);
        return res;
    }
}