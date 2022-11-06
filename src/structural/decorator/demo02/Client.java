package structural.decorator.demo02;

public class Client {
    public static void main(String[] args) {
        Style style = new Order();
        Style style1 = new ColorDecorator(style);
        Style style2 = new RadiusDecorator(style1);
        style2.style();
    }
}
