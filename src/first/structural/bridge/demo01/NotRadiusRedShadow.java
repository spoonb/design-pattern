package first.structural.bridge.demo01;

public class NotRadiusRedShadow extends NotRadiusRed {
    public void style() {
        super.style();
        this.shadow();
    }

    protected void shadow() {
        System.out.println("边框阴影");
    }
}