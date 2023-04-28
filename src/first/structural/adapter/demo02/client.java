package first.structural.adapter.demo02;

import java.util.ArrayList;
import java.util.List;

public class client {
	public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", "男", 19));
        users.add(new User("李四", "男", 35));
        users.add(new User("小红", "女", 21));
        JsonFilterAdapter jfa = new JsonFilterAdapter(users);
        String allUser = jfa.allToJson();
        String user = jfa.findByNameToJson("张三");
        System.out.printf("%s%n%s", allUser, user);
    }
}