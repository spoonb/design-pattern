package first.creational.builder.demo02;

public class Employee {
    private String name;
    private String sex;
    private int age;
    private String address; // 住址
    private String post; // 邮编
    private String company; // 公司
    private String department; // 部门

    private Employee(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
        this.address = builder.address;
        this.post = builder.post;
        this.company = builder.company;
        this.department = builder.department;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String sex;
        private int age;
        private String address; // 住址
        private String post; // 邮编
        private String company; // 公司
        private String department; // 部门

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder post(String post) {
            this.post = post;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            if (!("男".equals(sex) || "女".equals(sex))) {
                throw new RuntimeException("输入错误的性别：" + sex);
            }
            if (age <= 1 || age >= 150) {
                throw new RuntimeException("输入错误的年龄：" + age);
            }
            if (!postCheck()) {
                throw new RuntimeException("地址(" + address + ")与邮编(" + post + ")不一致");
            }
            return new Employee(this);
        }

        private boolean postCheck() {
            if (address == null/* || ... */) { // 非空check，以及其它的check(省略)，address的post与设置的post是否一致等
                return false;
            }
            return true;
        }
    }
}
