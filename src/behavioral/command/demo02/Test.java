package behavioral.command.demo02;

import java.util.List;

public class Test extends Command {
    public Test(Server server) {
        super(server);
    }

    public Test(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====Test start=====");
        for (Server app : servers) {
            app.test();
        }
        System.out.println("=====Test end=====");
    }
}
