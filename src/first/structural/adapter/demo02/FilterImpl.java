package first.structural.adapter.demo02;

import java.util.List;

public class FilterImpl implements Filter { // Adaptee
    List<User> users;
    public FilterImpl(List<User> users) {
        this.users = users;
    }
    public List<User> findAll() {
        return users;
    }
    public User findByName(String name) {
        if (name == null) throw new RuntimeException("请输入正确的ID!");
        return (User) users.stream().filter(t -> name.equals(t.name)).findFirst().orElse(null);
    }
}