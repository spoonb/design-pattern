package behavioral.command.demo03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("12.14.15.16", "测试环境01"));
        servers.add(new Server("12.14.15.17", "测试环境02"));
        servers.add(new Server("12.14.15.18", "测试环境03"));
        servers.add(new Server("12.14.15.19", "测试环境04"));

        // 组装所有需要执行的命令，可以通过反射配置在文件里
        BufferedReader br = new BufferedReader(new FileReader("src/behavioral/command/demo03/resource/cmds"));
        Manager man = new Manager();
        String s = null;
        while ((s = br.readLine()) != null) {
            man.addCmd((Command) Class.forName(s).getDeclaredConstructor(List.class).newInstance(servers));
        }
        br.close();

        // 发送命令
        man.invokeCmd();
    }
}
