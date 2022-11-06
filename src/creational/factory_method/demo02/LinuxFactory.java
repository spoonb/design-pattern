package creational.factory_method.demo02;

public class LinuxFactory implements Factory {
    @Override
    public Uploader uploader() {
        return new LinuxUploader();
    }
}
