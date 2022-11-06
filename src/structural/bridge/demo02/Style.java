package structural.bridge.demo02;

public class Style {
    private Radius radius;
    private Color color;
    private Shadow shadow;

    public Style(Radius radius, Color color, Shadow shadow) {
        this.radius = radius;
        this.color = color;
        this.shadow = shadow;
    }

    public void init() {
        radius.radius();
        color.color();
        shadow.shadow();
    }
}