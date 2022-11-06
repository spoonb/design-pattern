package structural.bridge.demo01;

public class NotRadiusBlue extends NotRadius {
    public void style() {
        super.style();
        this.blue();
    }

    protected void blue() {
        System.out.println("蓝色边框");
    }
}