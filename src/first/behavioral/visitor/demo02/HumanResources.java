package first.behavioral.visitor.demo02;

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
