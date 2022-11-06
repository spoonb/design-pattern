package behavioral.observer.demo01;

public class Client {

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
        monitor(server);
        for (int i = 0; i < 4; i ++) {
            server.startASoft();
            monitor(server);
        }
        server.stopASoft();
        monitor(server);
    }

    // server的所有参数都在客户端中监听, 随着开发的不断进行, 客户端会越发臃肿且难以维护
    public static void monitor(Server server) {
        if (server.getCpu() >= 85)
            System.out.printf("警告, cpu使用率 --> %s%%\n", server.getCpu());
        if (server.getMemory() >= 90)
            System.out.printf("警告, 内存使用率 --> %s%%\n", server.getMemory());
        if (server.getDisk() >= 95)
            System.out.printf("警告, 硬盘使用率 --> %s%%\n", server.getDisk());
        if (server.getGpu() >= 85)
            System.out.printf("警告, gpu使用率 --> %s%%\n", server.getGpu());
    }
}
