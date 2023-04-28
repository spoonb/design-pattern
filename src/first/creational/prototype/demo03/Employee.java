package first.creational.prototype.demo03;

public class Employee implements Cloneable {
    private String name;
    private String sex;
    private int age;
    private String country;
    private String province;
    private String city;
    private String post;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
