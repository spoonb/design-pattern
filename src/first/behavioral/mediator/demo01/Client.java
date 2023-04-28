package first.behavioral.mediator.demo01;

public class Client {

    // 可以看出不使用中介者设计模式时，需要在客户端控制用户对象间的通信，这很麻烦
    public static void main(String[] args) {
        User zs = new User("张三", "男", 25);
        User ls = new User("李四", "男", 28);
        User we = new User("王二", "男", 27);
        User zl = new User("赵六", "男", 21);
        User zy = new User("只因", "男", 15);

        // 模拟用户间发消息
        zs.send(ls, "暗号？");
        ls.send(zs, "鸡你太美？");
        zs.send(we, "暗号？");
        we.send(zs, "只因你太美。");
        zs.send(zl, "暗号？");
        zl.send(zs, "基尼太美");
        zs.send(zy, "暗号？");
        zy.send(zs, "我是坤坤！");
    }
}
