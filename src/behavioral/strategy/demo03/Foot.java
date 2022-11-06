package behavioral.strategy.demo03;

// 徒步去目的地
public class Foot implements Trans {
    @Override
    public void toTarget(String target) {
        System.out.println("徒步到目的地:" + target);
    }
}