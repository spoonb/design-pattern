package behavioral.strategy.demo03;

// 骑自行车去目的地
public class Bike implements Trans {
    @Override
    public void toTarget(String target) {
        System.out.println("骑自行车到目的地:" + target);
    }
}