package structural.decorator.demo01;

public class RadiusDecorator implements Style {
    private Style style;
    public RadiusDecorator(Style target) {
        this.style = target;
    }
    @Override
    public void style() {
        style.style();
        decorator();
    }
    private void decorator() {
        System.out.println("设置Radius");
    }
}
