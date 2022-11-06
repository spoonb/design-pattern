package creational.prototype.demo01;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        Employee emp = new Employee("张三", "男", 15, "中国", "江西省", "南昌市", "124-1241-1353");
        Department department = new Department("开发部", "中国", "江西省", "南昌市", List.of(emp)); // 已知对象
        Department department1 = new Department(department.getName(), department.getCountry(), department.getProvince(), department.getCity(), department.getEmployees()); // 拷贝对象
        System.out.println(department == department1); // false
    }
}
