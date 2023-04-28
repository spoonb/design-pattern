package first.behavioral.state.demo02;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Context context = new Context();
        System.out.print("是否提交申请?(y/n): ");
        do {
            try {
                context.execute("y".equals(sc.next()));
                System.out.println();
                System.out.print("是否审核通过?(y/n): "); // 这是个为了说明状态模式的案例，不用纠结提示语不够明确的问题
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return; // 结束工作流
            }
        } while (true);
    }
}
