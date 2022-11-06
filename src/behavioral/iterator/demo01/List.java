package behavioral.iterator.demo01;

public class List<T> {

    private Object[] arr = new Object[16];
    private int idx;
    private int size;

    public void add(T t) {
        if (idx >= arr.length) {
            arrCopy();
        }
        arr[idx ++] = t;
        size ++;
    }

    public T get(int i) {
        return (T) arr[i];
    }

    public int size() {
        return size;
    }

    private void arrCopy() {
        Object[] newArr = new Object[arr.length << 1];
        for (int i = 0; i < arr.length; i ++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
