package first.creational.prototype.demo01;

public class Employee {
    private String name;
    private String sex;
    private int age;
    private String country;
    private String province;
    private String city;
    private String post;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
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

    public String getPost() {
        return post;
    }

    public Employee(String name, String sex, int age,
                    String country, String province,
                    String city, String post) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
        this.province = province;
        this.city = city;
        this.post = post;
    }
}
