package behavioral.command.demo02;

import java.util.List;

public class Upload extends Command {
    public Upload(Server server) {
        super(server);
    }

    public Upload(List<Server> servers) {
        super(servers);
    }

    @Override
    public void execute() {
        System.out.println("=====upload start=====");
        for (Server server : servers) {
            server.upload();
        }
        System.out.println("=====upload end=====");
    }
}
