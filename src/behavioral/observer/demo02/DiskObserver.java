package behavioral.observer.demo02;

public class DiskObserver implements Observer {

    private Server server;

    public DiskObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getDisk() >= 95)
            System.out.printf("警告, 硬盘使用率 --> %s%%\n", server.getDisk());
    }
}
