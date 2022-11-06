package behavioral.command.demo02;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        // 组装所有需要执行的命令
        Manager man = new Manager();
        man.addCmd(new Upload(servers));
        man.addCmd(new Test(servers));
        man.addCmd(new Release(servers));

        // 发送命令
        man.invokeCmd();
    }
}
