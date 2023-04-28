package first.structural.decorator.demo02;

public class ColorDecorator extends StyleDecorator {
    public ColorDecorator(Style target) {
        super(target);
    }
    @Override
    protected void decorator() {
        System.out.println("设置Color");
    }
}
