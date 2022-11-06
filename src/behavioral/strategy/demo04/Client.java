package behavioral.strategy.demo04;

import java.util.Scanner;

// 客户端
public class Client {
    public static void main(String[] args) {
        String target = "公园";
        Scanner sc = new Scanner(System.in);
        Context context = Factory.create(sc.next());
        context.toTarget(target);
        sc.close();
    }
}