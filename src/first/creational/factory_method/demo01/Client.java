package first.creational.factory_method.demo01;

public class Client {
    public static void main(String[] args) throws Exception {
        Uploader uploader = Factory.uploader("LinuxUploader");
    }
}
