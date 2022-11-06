package behavioral.command.demo01;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static List<Server> servers  = new ArrayList<>();

    public static void main(String[] args) {
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        for (Server app : servers) {
            app.upload();
            app.release();
        }
    }
}
