package structural.decorator.demo01;

public class ColorDecorator implements Style {
    private Style style;
    public ColorDecorator(Style target) {
        this.style = target;
    }
    @Override
    public void style() {
        style.style();
        decorator();
    }
    private void decorator() {
        System.out.println("设置Color");
    }
}
