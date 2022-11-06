package behavioral.memento.demo02;

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
