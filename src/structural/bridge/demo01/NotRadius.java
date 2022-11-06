package structural.bridge.demo01;

public class NotRadius implements Style {
    public void style() {
        radius();
    }

    protected void radius() {
        System.out.println("无边框圆角");
    }
}