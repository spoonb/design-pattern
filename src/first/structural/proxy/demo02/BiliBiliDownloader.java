package first.structural.proxy.demo02;

import java.util.HashMap;
import java.util.Map;

public class BiliBiliDownloader {
    // 定义用来缓存数据的map对象
    private static Map<String, byte[]> map = new HashMap<>();
    public byte[] download(String filePath) throws InterruptedException {
        System.out.printf("正在下载BiliBili文件：%s%n", filePath);
        if (map.containsKey(filePath)) {
            return map.get(filePath);
        }
        // 模拟文件下载，睡个10秒
        Thread.sleep(10000);
        byte[] res = new byte[1024]; // 假装这是下载后的字节数组
        map.put(filePath, res); // 加入缓存
        return res;
    }
}
