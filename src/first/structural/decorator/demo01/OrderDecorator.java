package first.structural.decorator.demo01;

public class OrderDecorator implements Style {
    private Style style;
    public OrderDecorator(Style target) {
        this.style = target;
    }
    @Override
    public void style() {
        style.style();
        decorator();
    }
    private void decorator() {
        System.out.println("设置Order");
    }
}
