## 简述

保存版本记录，以及根据保存的记录还原成指定版本。

实现非常的简单，话不多说，看个优化案例。

## 优化案例

### 最初版v0

```java
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

public class Goods {

    private String name;
    private double price;
    private String description;

    public Goods(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
```

对象的版本保存和还原都是在客户端中实现的。客户端不应该涉及各种底层的业务逻辑，所以这需要优化，详情看下面的修改案例。

### 修改版v1

```java
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

public class Goods {

    private String name;
    private double price;
    private String description;

    public Goods(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Goods setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goods setDescription(String description) {
        this.description = description;
        return this;
    }
}

/**
 * 负责存取备忘录
 */
public class Caretaker {

    private List<Memento> mementos = new ArrayList<>();

    /**
     * 获取所有历史记录
     * @return 所有历史记录
     */
    public List<Memento> getMementos() {
        return this.mementos;
    }

    /**
     * 获取指定下标的历史记录
     * @param idx 下标
     * @return 指定下标的历史记录
     */
    public Memento getMemento(int idx) {
        return mementos.get(idx);
    }

    /**
     * 添加一条历史记录
     * @param memento 备忘录
     */
    public void addMemento(Memento memento) {
        mementos.add(memento);
    }
}

public class Memento<T> {

    private T snapshot;

    public Memento(T snapshot) {
        Gson gson = new Gson();
        this.snapshot = (T) gson.fromJson(gson.toJson(snapshot), snapshot.getClass());
    }

    public T getSnapshot() {
        return snapshot;
    }
}

/**
 * 迭代与回滚当前备忘录的版本
 * @param <T>
 */
public class Originator<T> {

    private T obj;

    public Originator(T obj) {
        this.obj = obj;
    }

    public Memento createMemento() {
        return new Memento<>(obj);
    }

    /**
     * 回滚重置状态
     * @param memento 目标状态
     * @return 回复后的对象
     */
    public T restore(Memento memento) {
        return obj = (T) memento.getSnapshot();
    }

    public T getObj() {
        return obj;
    }
}
```

`Originator`用来创建备份，使用`Caretaker`来保存备份和还原备份。客户端也不用实现具体的备份和还原功能了。

## 总结

### 优点

- 备份对象并构建备份的历史记录，可以根据业务还原到任何一个备份。

### 缺点

- 实现简单，讲道理没觉得有啥缺点，如果一定要说那就是增加了类的数量（有点吹毛求疵）。

### 适用场景

- 需要备份历史记录或者需要根据业务还原到历史版本时。
