package structural.bridge.demo01;

public class NotRadiusRed extends NotRadius {
    public void style() {
        super.style();
        this.red();
    }

    protected void red() {
        System.out.println("红色边框");
    }
}