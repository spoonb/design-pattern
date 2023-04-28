package first.structural.facade.demo02;

public class Taobao {
    private static Facade facade = new Facade();
    public static void main(String[] args) {
        facade.flow();
    }
}