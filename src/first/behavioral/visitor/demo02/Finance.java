package first.behavioral.visitor.demo02;

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
