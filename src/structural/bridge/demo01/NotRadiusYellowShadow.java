package structural.bridge.demo01;

public class NotRadiusYellowShadow extends NotRadiusYellow {
    public void style() {
        super.style();
        this.shadow();
    }

    protected void shadow() {
        System.out.println("边框阴影");
    }
}