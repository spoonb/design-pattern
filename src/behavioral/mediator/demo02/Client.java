package behavioral.mediator.demo02;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        User zs = new User("张三", "男", 25);
        User ls = new User("李四", "男", 28);
        User we = new User("王二", "男", 27);
        User zl = new User("赵六", "男", 21);
        User zy = new User("只因", "男", 15);

        // 创建群组
        List<User> users = new ArrayList<>();
        users.add(zs);
        users.add(ls);
        users.add(we);
        users.add(zl);
        users.add(zy);
        zs.register("ikun", users);

        System.out.println("=====张三发消息开始=====");
        zs.send("ikun", "暗号？");
        System.out.println("=====张三发消息结束=====");

        System.out.println("=====李四发消息开始=====");
        ls.send("ikun", "基尼太美");
        System.out.println("=====李四发消息结束=====");

        System.out.println("=====只因发消息开始=====");
        zy.send("ikun", "我就是坤坤");
        System.out.println("=====只因发消息结束=====");
    }
}
