package behavioral.strategy.demo03;

// 开车去目的地
public class Car implements Trans {
    @Override
    public void toTarget(String target) {
        System.out.println("开车到目的地:" + target);
    }
}