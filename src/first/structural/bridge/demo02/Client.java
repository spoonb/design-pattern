package first.structural.bridge.demo02;

public class Client {
    public static void main(String[] args) {
        Style style = new Style(new HasRadius(), new Red(), new HasShadow());
        style.init();
    }
}