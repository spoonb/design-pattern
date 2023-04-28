package first.behavioral.observer.demo02;

public class Client {

    public static void main(String[] args) {
        Server server = new Server();
        server.addOb(new CPUObserver(server));
        server.addOb(new MemoryObserver(server));
        server.addOb(new DiskObserver(server));
        server.addOb(new GPUObserver(server));

        // 将每种不同参数的监听教给不同的观察者, 而不是定义在客户端中
        server.startServer();
        for (int i = 0; i < 4; i ++) {
            server.startASoft();
        }
        server.stopASoft();
    }
}
