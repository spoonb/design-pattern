package behavioral.state.demo01;

import java.util.Scanner;

public class Client {
    private static String flag = "apply";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("是否提交申请?(y/n)");
        if ("y".equals(sc.next())) {
            System.out.println("申请已提交，请等待审查。");
            flag = "accept1st";
        } else {
            System.out.println("申请已撤销。");
            return;
        }
        for (;;) {
            if ("accept1st".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("一次审核通过，进入二次审核阶段。");
                    flag = "accept2nd";
                } else {
                    System.out.println("一次审核未通过，请整理资料后重新申请。");
                    break;
                }
            } else if ("accept2nd".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("二次审核通过，进入三次审核阶段。");
                    flag = "accept3rd";
                } else {
                    System.out.println("二次审核未通过，回到一次审核阶段。");
                    flag = "accept1st";
                }
            } else if ("accept3rd".equals(flag)) {
                if ("y".equals(sc.next())) {
                    System.out.println("三次审核通过，恭喜您的申请已通过。");
                    flag = "complete";
                    break;
                } else {
                    System.out.println("三次审核未通过，回到二次审核阶段。");
                    flag = "accept2nd";
                }
            }
        }
    }
}
