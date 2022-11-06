package creational.prototype.demo04;

import com.google.gson.Gson;

import java.util.List;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e = new Employee("张三", "男", 15, "中国", "江西省", "南昌市", "124-1241-1353");
        Department department = new Department("开发部", "中国", "江西省", "南昌市", List.of(e));
        Gson gson = new Gson();
        String s = gson.toJson(department);
        Department department1 = gson.fromJson(s, Department.class);
        System.out.println(department == department1); // false
        System.out.println(department.getEmployees() == department1.getEmployees()); // false
    }
}
