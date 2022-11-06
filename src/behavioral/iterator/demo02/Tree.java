package behavioral.iterator.demo02;

public class Tree<T> implements Collect {

    private Tree left, right;

    private T value;

    public Tree(T value) {
        this.value = value;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this);
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public Tree setLeft(Tree left) {
        this.left = left;
        return this;
    }

    public Tree setRight(Tree right) {
        this.right = right;
        return this;
    }
}
