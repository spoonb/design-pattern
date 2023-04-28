package first.structural.bridge.demo01;

public class RadiusBlue extends Radius {
    public void style() {
        super.style();
        this.blue();
    }

    protected void blue() {
        System.out.println("蓝色边框");
    }
}