package creational.factory_method.demo02;

public class UnixFactory implements Factory {
    @Override
    public Uploader uploader() {
        return new UnixUploader();
    }
}
