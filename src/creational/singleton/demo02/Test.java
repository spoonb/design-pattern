package creational.singleton.demo02;

public class Test {
    private static Test ins;

    public static synchronized Test instance() {
        if (ins == null) ins = new Test();
        return ins;
    }
}