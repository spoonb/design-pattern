package behavioral.visitor.demo01;

public class Employee {

    private String name;
    private String sex;
    private int age;
    private double hours; // 实际工时
    private double minHours = 160; // 最低工时，低于该值则当月时薪降20
    private double maxHours = 180; // 最高工时，高于该值则超出部分时薪为原有的1.3倍
    private double price = 600; // 时薪(元)

    // 财务部对于员工本月工资汇总
    public void price() {
        double total = 0; // 月薪
        if (hours < minHours) {
            total = (price - 20) * hours;
        } else if (hours > maxHours) {
            total = price * hours + price * (maxHours - hours) *1.3;
        } else {
            total = price * hours;
        }
        System.out.printf("%.2f\n", total); // 输出计算后的本月工资
    }

    // 人事部对于员工本月勤务情况评价
    public void level() {
        double midHours = (maxHours + minHours) / 2;
        char level = 'B'; // 初始为B，良。C为合格
        if (price > 500) { // 高成本判定，时薪超过500元/时为高成本
            level += 1;
        }
        if (hours < minHours || hours > maxHours) {
            level += 2;
        } else if (hours > midHours) { // 反对加班
            level += 1;
        } else {
            level -= 1;
        }
        System.out.printf("%c\n", level); // 输出评价等级
    }

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
