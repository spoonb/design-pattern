package structural.adapter.demo02;

public class User {
    String name;
    String sex;
    int age;
    // 剩下的属性就不写了，都是废话没啥意义
    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}