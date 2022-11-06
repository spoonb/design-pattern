package structural.decorator.demo01;

public class Order implements Style {
    @Override
    public void style() {
        System.out.println("设置Order");
    }
}