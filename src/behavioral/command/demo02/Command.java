package behavioral.command.demo02;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    protected List<Server> servers = new ArrayList<>();

    public Command(Server app) {
        this.servers.add(app);
    }

    public Command(List<Server> apps) {
        this.servers = apps;
    }

    public abstract void execute();
}
