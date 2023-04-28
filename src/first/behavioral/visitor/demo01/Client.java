package first.behavioral.visitor.demo01;

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
