package first.structural.bridge.demo01;

public class NotRadiusYellow extends NotRadius {
    public void style() {
        super.style();
        this.yellow();
    }

    protected void yellow() {
        System.out.println("黄色边框");
    }
}