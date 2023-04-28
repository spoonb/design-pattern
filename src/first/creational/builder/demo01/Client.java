package first.creational.builder.demo01;

public class Client {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setPost("121-1245-1231"); // 地址(null)与邮编(121-1245-1231)不一致，报错
    }
}
