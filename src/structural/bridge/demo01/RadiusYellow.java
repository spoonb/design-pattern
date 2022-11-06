package structural.bridge.demo01;

public class RadiusYellow extends Radius {
    public void style() {
        super.style();
        this.yellow();
    }

    protected void yellow() {
        System.out.println("黄色边框");
    }
}