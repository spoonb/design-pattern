package structural.bridge.demo01;

public class Radius implements Style {
    public void style() {
        radius();
    }

    protected void radius() {
        System.out.println("有边框圆角");
    }
}