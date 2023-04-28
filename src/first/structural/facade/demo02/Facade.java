package first.structural.facade.demo02;

public class Facade {
    private Customer customer = new Customer();
    private Shop shop = new Shop();
    private Logistics logistics = new Logistics();
    public void flow() {
        customer.start();
        shop.accpet();
        logistics.send();
        customer.end();
    }
}