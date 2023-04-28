package first.behavioral.visitor.demo02;

public class Employee { // 访问模式中的元素

    private String name;
    private String sex;
    private int age;
    private double hours; // 实际工时
    private double minHours = 160; // 最低工时，低于该值则当月时薪降20
    private double maxHours = 180; // 最高工时，高于该值则超出部分时薪为原有的1.3倍
    private double price = 600; // 时薪(元)

    public Employee(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public double getMinHours() {
        return minHours;
    }

    public double getMaxHours() {
        return maxHours;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
