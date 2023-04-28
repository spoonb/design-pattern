package first.behavioral.iterator.demo02;

public class ListIterator<T> implements Iterator<T> {

    private List<T> arrayList;
    private int idx;

    public ListIterator(List<T> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        if (idx < arrayList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new RuntimeException("无下一个元素！！！");
        }
        return arrayList.get(idx ++);
    }
}
