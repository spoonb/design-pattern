package behavioral.memento.demo02;

public class Client {

    public static void main(String[] args) {
        Originator<Goods> origin = new Originator(new Goods("iPhone14", 14000, "原始价格"));
        Goods goods = origin.getObj();
        Caretaker caretaker = new Caretaker();
        caretaker.addMemento(origin.createMemento()); // 保存原始版本
        goods.setDescription("全场打7折促销！").setPrice(9800);
        caretaker.addMemento(origin.createMemento()); // 保存7折版本
        goods.setDescription("市场反响很好, 微微上调200！").setPrice(10000);
        caretaker.addMemento(origin.createMemento()); // 保存微调后版本
        for (Memento<Goods> memento : caretaker.getMementos()) {
            Goods snapshot = memento.getSnapshot();
            System.out.printf("goods: {description: \"%s\", name: \"%s\", price: \"%s\"}\n",
                    snapshot.getDescription(), snapshot.getName(), snapshot.getPrice());
        }
        Goods restore = origin.restore(caretaker.getMemento(1));// 回退到下标为1的历史记录
        System.out.printf("goods: {description: \"%s\", name: \"%s\", price: \"%s\"}\n",
                restore.getDescription(), restore.getName(), restore.getPrice());
        caretaker.addMemento(origin.createMemento());
        for (Memento<Goods> memento : caretaker.getMementos()) {
            Goods snapshot = memento.getSnapshot();
            System.out.printf("goods: {description: \"%s\", name: \"%s\", price: \"%s\"}\n",
                    snapshot.getDescription(), snapshot.getName(), snapshot.getPrice());
        }
    }
}
