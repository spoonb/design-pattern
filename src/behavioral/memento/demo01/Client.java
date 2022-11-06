package behavioral.memento.demo01;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static List<Goods> memory = new ArrayList<>();

    // 需要操作商品对象更新商品价格（客户端逻辑上的本职工作）,又负责深拷贝以及备份存储的实现细节
    // 客户端的这个模块太复杂了，得想办法优化
    public static void main(String[] args) {
        Gson gson = new Gson();
        Goods goods = new Goods("iPhone14", 14000, "原始价格");
        // 通过序列化和反序列化来实现对象的深拷贝
        memory.add(gson.fromJson(gson.toJson(goods), Goods.class)); // 保存原始版本
        goods.setDescription("全场打7折促销！");
        goods.setPrice(9800);
        memory.add(gson.fromJson(gson.toJson(goods), Goods.class)); // 保存7折版本
        goods.setDescription("市场反响很好，微微上调200！");
        goods.setPrice(10000);
        memory.add(gson.fromJson(gson.toJson(goods), Goods.class)); // 保存微调后版本
    }
}
