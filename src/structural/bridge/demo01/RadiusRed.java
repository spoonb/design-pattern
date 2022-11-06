package structural.bridge.demo01;

public class RadiusRed extends Radius {
    public void style() {
        super.style();
        this.red();
    }

    protected void red() {
        System.out.println("红色边框");
    }
}