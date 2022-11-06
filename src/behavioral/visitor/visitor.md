## 简述

由于关注点不同，进而对一组元素进行不同的操作。

> 如，对于同一个人的一季度的出勤记录，财务部关注的是工作时长计算月底工资；而人事部关注的是工作时长统计出这个员工的出勤率等，并给予评估。
>
> 不同的访问者对于相同的数据有着不同的操作。

话不多说，看一个案例。

## 优化案例

随着公司无纸化办公的推进，新的需求也随之而来。
现在想推进一组与员工勤务相关的需求，如下。

> 1. 财务部根据员工每个月的出勤记录通过无纸化办公系统出具月底工资单。
> 2. 人事部根据员工每个月的出勤记录通过无纸化办公系统出具月底评级表。

### 最初版v0

由于现行系统中员工持有者各自出勤记录的数据，并且还持有与工资单和评价单息息相关的诸如时薪，契约每月最低最高工时等。所以就有了一下最初的一版代码。

```java
// 客户端
public class Client {

    public static void main(String[] args) {
        Employee emp = new Employee("张三", "男", 27);
        emp.setHours(160); // 本月工作时常

        // 财务部对于员工本月工资汇总
        emp.price();
        // 人事部对于员工本月勤务情况评价
        emp.level();
    }
}

// 员工类
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
```

可以看出，现在工资单和评价表的功能都定义在员工类中，这会有两个问题。

1. 从业务角度，工资单应该由财务部门出具，而评价表则是人事部。业务上变得混乱。
2. 从代码角度，如日后有了新的部分需要依据员工信息统计出其它数据时，按照现有代码的结构必须修改员工类的定义，增加对应的新方法。

使用访问者模式，可以解决以上问题。

### 修改版v1

```java
// 客户端
public class Client {

    public static void main(String[] args) {
        Employee emp = new Employee("张三", "男", 27);
        emp.setHours(160); // 本月工作时常

        // 财务部对于员工本月工资汇总
        Department fd = new Finance();
        fd.accept(emp);
        // 人事部对于员工本月勤务情况评价
        Department hrd = new HumanResources();
        hrd.accept(emp);
    }
}

// 员工类
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

// 部门接口(抽象访问者)
public interface Department {
    void accept(Employee emp);
}

// 财务部类(具体访问者)
public class Finance implements Department {
    @Override
    public void accept(Employee emp) {
        price(emp);
    }
    
    private void price(Employee emp) {
        double price = emp.getPrice();
        double hours = emp.getHours();
        double maxHours = emp.getMaxHours();
        double minHours = emp.getMinHours();
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
}

// 人事部类(具体访问者)
public class HumanResources implements Department {
    @Override
    public void accept(Employee emp) {
        level(emp);
    }

    private void level(Employee emp) {
        double price = emp.getPrice();
        double hours = emp.getHours();
        double maxHours = emp.getMaxHours();
        double minHours = emp.getMinHours();
        // 人事部对于员工本月勤务情况评价
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
}
```

这种场合下使用访问者模式有以下两点好处。

1. 从业务的角度，代码的结构更加合理。
2. 从代码的角度，增加一个访问者时不需要更改原有的类，而是增加新的具体访问者即可。

## 总结

### 优点

- 将数据的存储与数据的操作访问隔离开，降低了单个类的复杂度
- 增加对数据操作的新业务角度时，直接增加新的访问者即可，符合开闭原则。

### 缺点

- 当需要增加或减少元素时，需要修改所有具体访问者。

### 适用场景

- 当元素种类固定不变，并且更具不同的业务对于相同元素有着不同操作时，可以使用。