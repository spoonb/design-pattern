package structural.facade.demo01;

public class Customer {
    public void start() {
        System.out.println("下单。。。");
    }
    public void end() {
        System.out.println("收件。。。");
        System.out.println("付款。。。");
    }
}