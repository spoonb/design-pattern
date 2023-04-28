package first.behavioral.strategy.demo01;

import java.util.Scanner;

// 客户端
public class Client {
    public static void main(String[] args) {
        String target = "公园";
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if ("foot".equals(input)) {
            System.out.println("徒步到目的地:" + target);
        } else if ("bike".equals(input)) {
            System.out.println("骑自行车到目的地:" + target);
        } else if ("car".equals(input)) {
            System.out.println("开车到目的地:" + target);
        }
        sc.close();
    }
}