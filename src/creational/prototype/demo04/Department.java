package creational.prototype.demo04;

import lombok.Data;

import java.util.List;

@Data
public class Department {
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
}
