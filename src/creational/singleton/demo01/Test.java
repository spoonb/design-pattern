package creational.singleton.demo01;

public class Test {
    private static Test ins = new Test();
    public static Test instance() {
        return ins;
    }
}