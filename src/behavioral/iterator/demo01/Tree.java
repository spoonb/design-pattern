package behavioral.iterator.demo01;

public class Tree<T> {

    private Tree left, right;

    private T value;

    public Tree(T value) {
        this.value = value;
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
