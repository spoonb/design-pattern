package structural.decorator.demo02;

public class Color implements Style {
    @Override
    public void style() {
        System.out.println("设置Color");
    }
}
