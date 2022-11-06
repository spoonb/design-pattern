package structural.decorator.demo02;

public class Order implements Style {
    @Override
    public void style() {
        System.out.println("设置Order");
    }
}