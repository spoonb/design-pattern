package creational.prototype.demo03;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department implements Cloneable {
    private String name;
    private String country;
    private String province;
    private String city;
    private List<Employee> employees;

    public Department(String name, String country, String province,
                      String city, List<Employee> employees) {
        this.name = name;
        this.country = country;
        this.province = province;
        this.city = city;
        this.employees = employees;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Department department = (Department)super.clone();
        List<Employee> emps = new ArrayList<>();
        for (int i = 0; i < department.employees.size(); i ++) {
            emps.add((Employee) employees.get(i).clone());
        }
        department.employees = emps;
        return department;
    }
}
