package first.structural.proxy.demo04;

import java.io.FileReader;
import java.util.Properties;

public class Client {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileReader("src/resource/props/config.prop"));
        Downloader downloader = (Downloader) Class.forName(prop.getProperty("PROXY_NAME"))
                .getDeclaredConstructor().newInstance();
        downloader.download("/root/home/buzuweiqi/java_manual.txt");
        downloader = new ProxyYoutubeDownloader();
        downloader.download("/root/home/buzuweiqi/linux_manual.txt");
    }
}