package first.structural.decorator.demo02;

public class RadiusDecorator extends StyleDecorator {
    public RadiusDecorator(Style target) {
        super(target);
    }
    @Override
    protected void decorator() {
        System.out.println("设置Radius");
    }
}
