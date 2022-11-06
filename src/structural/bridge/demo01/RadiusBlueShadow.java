package structural.bridge.demo01;

public class RadiusBlueShadow extends RadiusBlue {
    public void style() {
        super.style();
        this.shadow();
    }

    protected void shadow() {
        System.out.println("有边框阴影");
    }
}