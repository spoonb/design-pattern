package creational.abstract_factory.demo04;

import java.io.FileReader;
import java.util.Properties;

public class Client {
    private static Factory factory;
    
    // 通过Java的反射机制创建上述factory对象
    static {
        try {
            // 读取prop配置文件
            Properties prop = new Properties();
            FileReader fileReader = new FileReader("src/creational/abstract_factory/demo04/resource/props/config.prop");
            prop.load(fileReader);
            fileReader.close();
            factory = (Factory) Class.forName(prop.getProperty("FACTORY"))
                    .getDeclaredConstructor().newInstance();
        } catch(Exception ex) {
            ex.getStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Uploader uploader = factory.uploader();
        Downloader downloader = factory.downloader();
    }
}