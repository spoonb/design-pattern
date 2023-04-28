package first.creational.builder.demo02;

public class Client {

    public static void main(String[] args) {
        Employee e = Employee.Builder().name("张三").sex("男").age(35)
                .post("124-1241-1352").address("江西省南昌市").build(); // 执行成功
    }
}
