package behavioral.visitor.demo02;

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
