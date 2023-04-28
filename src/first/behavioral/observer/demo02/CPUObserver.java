package first.behavioral.observer.demo02;

public class CPUObserver implements Observer {

    private Server server;

    public CPUObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getCpu() >= 85)
            System.out.printf("警告, cpu使用率 --> %s%%\n", server.getCpu());
    }
}
