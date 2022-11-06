package behavioral.mediator.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * 群聊
 */
public class GroupChat implements ChatMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void register(User user) {
        users.add(user);
    }

    @Override
    public void sendMsg(String msg) {
        for (User user : users) {
            user.receive(msg);
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
