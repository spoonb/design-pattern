package first.behavioral.observer.demo02;

public class MemoryObserver implements Observer {

    private Server server;

    public MemoryObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getMemory() >= 90)
            System.out.printf("警告, 内存使用率 --> %s%%\n", server.getMemory());
    }
}
