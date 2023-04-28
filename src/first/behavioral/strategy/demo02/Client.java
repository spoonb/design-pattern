package first.behavioral.strategy.demo02;

import java.util.Scanner;

// 客户端
public class Client {
    public static void main(String[] args) {
        String target = "公园";
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if ("foot".equals(input)) {
            Foot foot = new Foot();
       		foot.toTarget(target);
        } else if ("bike".equals(input)) {
            Bike bike = new Bike();
        	bike.toTarget(target);
        } else if ("car".equals(input)) {
            Car car = new Car();
        	car.toTarget(target);
        }
        sc.close();
    }
}