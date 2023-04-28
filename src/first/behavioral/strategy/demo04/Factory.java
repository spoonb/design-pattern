package first.behavioral.strategy.demo04;

// 工厂类，创建持有不同Trans对象的上下文对象
public class Factory {
    public static Context create(String input) {
        if ("foot".equals(input)) {
            return new Context(new Foot());
        } else if ("bike".equals(input)) {
            return new Context(new Bike());
        } else if ("car".equals(input)) {
            return new Context(new Car());
        }
        return null;
    }
}