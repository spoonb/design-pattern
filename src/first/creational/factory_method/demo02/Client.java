package first.creational.factory_method.demo02;

public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = uploader(new LinuxFactory());
        Uploader uploader1 = uploader(new UnixFactory());
        System.out.println(uploader);
        System.out.println(uploader1);
    }

    public static Uploader uploader(Factory factory) {
        return factory.uploader();
    }
}
