package creational.prototype.demo01;

import java.util.List;

public class Department {
    private String name;
    private String country;
    private String province;
    private String city;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department(String name, String country, String province,
                      String city, List<Employee> employees) {
        this.name = name;
        this.country = country;
        this.province = province;
        this.city = city;
        this.employees = employees;
    }
}
