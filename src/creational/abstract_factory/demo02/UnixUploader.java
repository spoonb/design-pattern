package creational.abstract_factory.demo02;

// Unix环境下的上传实现
public class UnixUploader implements Uploader {
    public void upload(String fileName) {
        System.out.printf("[Unix]正在上传%s...", fileName);
    }
}