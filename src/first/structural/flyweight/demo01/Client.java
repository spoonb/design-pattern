package first.structural.flyweight.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        List<Computer> purchase = new ArrayList<>();
        for (int i = 0; i < 15; i ++) {
            purchase.add(new Computer(UUID.randomUUID().toString(),
                         "华为", "MateBook16", "锐龙7 5800H标压",
                         "16GB DDR4 双通道", "512GB NVMe PCle SSD", 
                         "gpu", "全尺寸背光键盘", "16英寸"));
        }
    }
}