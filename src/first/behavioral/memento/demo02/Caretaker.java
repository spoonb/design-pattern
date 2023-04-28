package first.behavioral.memento.demo02;

import java.util.ArrayList;
import java.util.List;

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
