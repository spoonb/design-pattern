package creational.singleton.demo03;

public class Test {
    private static Test ins;

    public static Test instance() {
        if (ins == null) {
            synchronized (Test.class) {
                if (ins == null) ins = new Test();
            }
        }
        return ins;
    }
}