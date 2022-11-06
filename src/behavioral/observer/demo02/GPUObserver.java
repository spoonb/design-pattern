package behavioral.observer.demo02;

public class GPUObserver implements Observer {

    private Server server;

    public GPUObserver(Server server) {
        this.server = server;
    }

    @Override
    public void update() {
        if (server.getGpu() >= 85)
            System.out.printf("警告, gpu使用率 --> %s%%\n", server.getGpu());
    }
}
