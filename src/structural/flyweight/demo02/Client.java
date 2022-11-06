package structural.flyweight.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        List<Computer> purchase = new ArrayList<>();
        for (int i = 0; i < 15; i ++) {
            purchase.add(new Computer(UUID.randomUUID().toString(),
                                      ComputerSpec.MATEBOOK16));
        }
        // 由于订单错误，现在需要批量将MateBook16修改为MateBook16s
        ComputerSpec.MATEBOOK16.title = "MateBook16s";
    }
}