package creational.singleton.demo05;

public enum Test {
    INSTANCE;

    public static Test instance() {
        return INSTANCE;
    }
}