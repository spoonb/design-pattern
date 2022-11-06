package structural.decorator.demo02;

public class OrderDecorator extends StyleDecorator {
    public OrderDecorator(Style target) {
        super(target);
    }
    @Override
    public void style() {
        style.style();
        decorator();
    }
    @Override
    protected void decorator() {
        System.out.println("设置Order");
    }
}
