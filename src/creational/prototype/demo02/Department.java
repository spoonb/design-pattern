package creational.prototype.demo02;

import lombok.Data;

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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
