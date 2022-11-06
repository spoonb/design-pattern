package creational.builder.demo01;

public class Employee {
    private String name;
    private String sex;
    private int age;
    private String address; // 住址
    private String post; // 邮编
    private String company; // 公司
    private String department; // 部门
    public Employee() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
        if (!("男".equals(sex) || "女".equals(sex))) {
            throw new RuntimeException("输入错误的性别：" + sex);
        }
    }

    public void setAge(int age) {
        this.age = age;
        if (age <= 1 || age >= 150) {
            throw new RuntimeException("输入错误的年龄：" + age);
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPost(String post) {
        this.post = post;
        if (!postCheck()) {
            throw new RuntimeException("地址(" + address + ")与邮编(" + post + ")不一致");
        }
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private boolean postCheck() {
        if (address == null/* || ... */) { // 非空check，以及其它的check(省略)，address的post与设置的post是否一致等
            return false;
        }
        return true;
    }
}
