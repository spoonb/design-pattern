package first.behavioral.strategy.demo03;

import java.util.Scanner;

// 客户端
public class Client {
    public static void main(String[] args) {
        String target = "公园";
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Context context = null;
        if ("foot".equals(input)) {
            context = new Context(new Foot());
        } else if ("bike".equals(input)) {
            context = new Context(new Bike());
        } else if ("car".equals(input)) {
            context = new Context(new Car());
        }
        context.toTarget(target);
        sc.close();
    }
}