package first.structural.bridge.demo01;

public class RadiusRedShadow extends RadiusRed {
    public void style() {
        super.style();
        this.shadow();
    }

    protected void shadow() {
        System.out.println("有边框阴影");
    }
}