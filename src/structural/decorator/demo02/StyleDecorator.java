package structural.decorator.demo02;

public abstract class StyleDecorator implements Style {
    protected Style style;
    public StyleDecorator(Style target) {
        this.style = target;
    }
    @Override
    public void style() {
        style.style();
        decorator();
    }
    protected abstract void decorator();
}
