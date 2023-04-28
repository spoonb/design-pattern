package first.behavioral.mediator.demo02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String sex;
    private int age;

    private Map<String, ChatMediator> chatMap = new HashMap<>();

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void send(String chat, String msg) {
        chatMap.get(chat).sendMsg(msg);
    }

    public void receive(String msg) {
        System.out.printf("%s接收消息 <-- %s\n", name, msg);
    }

    // 注册群聊
    public void register(String name, List<User> users) {
        chatMap.put(name, new GroupChat());
        addUsers(name, users);
    }

    public void addUsers(String name, List<User> users) {
        if (chatMap.containsKey(name)) {
            ChatMediator chatMediator = chatMap.get(name);
            for (User user : users) {
                chatMediator.register(user);
                user.chatMap.put(name, chatMediator);
            }
            return;
        }
        throw new RuntimeException("不存在此群组，请先创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
