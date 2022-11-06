package creational.singleton.demo04;

public class Test {
    private static class Singleton {
        private static final Test ins = new Test();
    }

    public static Test instance() {
        return Singleton.ins;
    }
}