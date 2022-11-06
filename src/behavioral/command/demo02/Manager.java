package behavioral.command.demo02;

import java.util.ArrayList;
import java.util.List;

// invoker
public class Manager {
    private List<Command> cmds = new ArrayList<>();

    public void addCmd(Command cmd) {
        cmds.add(cmd);
    }

    public void invokeCmd() {
        for (Command cmd : cmds) {
            cmd.execute();
        }
    }
}
