package structural.bridge.demo01;

public class NotRadiusRedNotShadow extends NotRadiusRed {
    public void style() {
        super.style();
        this.shadow();
    }

    protected void shadow() {
        System.out.println("无边框阴影");
    }
}