package first.behavioral.mediator.demo02;

public interface ChatMediator {
    void register(User user);
    void sendMsg(String msg);
}
