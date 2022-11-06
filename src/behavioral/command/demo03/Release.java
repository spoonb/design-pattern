package behavioral.command.demo03;

import java.util.List;

public class Release extends Command {
    public Release(Server server) {
        super(server);
    }

    public Release(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====release start=====");
        for (Server app : servers) {
            app.release();
        }
        System.out.println("=====release end=====");
    }
}
