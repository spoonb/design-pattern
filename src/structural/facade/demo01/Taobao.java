package structural.facade.demo01;

public class Taobao {
    private static Customer customer = new Customer();
    private static Shop shop = new Shop();
    private static Logistics logistics = new Logistics();
    public static void main(String[] args) {
        customer.start();
        shop.accpet();
        logistics.send();
        customer.end();
    }
}