package first.creational.simple_factory.demo02;

// Linux环境下的上传实现
public class LinuxUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Linux]正在上传%s...", fileName);
    }
}