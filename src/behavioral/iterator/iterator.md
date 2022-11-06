## 简述

封装迭代细节，使得客户端可以使用统一的方式迭代不同的数据结构。

> **统一的方式迭代不同的数据结构**
> 对于线性表，我们通常使用for循环来迭代。而对于二叉树我们则一般使用`dfs`或者`bfs`的方式来迭代。可以看出二者的迭代方式并不相同，传统的方式需要客户端自己封装实现。而迭代器模式则将实现全部封装在服务端，客户端只需要使用迭代器的`hasNext()`和`next()`方法统一的处理数据即可。提高了客户端开发的效率。

话不多说，看个案例

## 优化案例

现在有一个需求需要迭代List或者Tree，代码如下。

### 最初版v0

```java
public class Client {

    public static void main(String[] args) {
        // list测试数据
        List<Integer> list = new List<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(5);

        // tree测试数据
        Tree one = new Tree(1);
        Tree two = new Tree(2);
        Tree three = new Tree(3);
        Tree four = new Tree(4);
        Tree five = new Tree(5);
        Tree six = new Tree(6);
        one.setLeft(two).setRight(three);
        two.setLeft(four).setRight(five);
        three.setLeft(six);

        // list迭代器测试
        System.out.println("=====list的迭代开始=====");
        for (int i = 0; i < list.size(); i ++) {
            System.out.printf("%s ", list.get(i)); // list的迭代方式
        }
        System.out.println("\n=====list的迭代结束=====");

        // tree迭代器测试
        System.out.println("=====tree的迭代开始=====");
        treeItr(one);
        System.out.println("\n=====tree的迭代结束=====");
    }

    public static void treeItr(Tree tree) {
        if (tree.getLeft() != null) {
            treeItr(tree.getLeft());
        }
        System.out.printf("%s ", tree.getValue());
        if (tree.getRight() != null) {
            treeItr(tree.getRight());
        }
    }
}

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
```

虽然满足了需求，但有两点值得注意的问题。

1. 客户端中编写了迭代List和Tree所需的核心代码逻辑。
2. List和Tree在客户端中的迭代方式不同，使得系统使用不够便利。

使用迭代器模式即可优化上述代码。

### 修改版v1

```java
public class Client {

    public static void main(String[] args) {
        // list测试数据
        List<Integer> list = new List<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(5);

        // tree测试数据
        Tree one = new Tree(1);
        Tree two = new Tree(2);
        Tree three = new Tree(3);
        Tree four = new Tree(4);
        Tree five = new Tree(5);
        Tree six = new Tree(6);
        one.setLeft(two).setRight(three);
        two.setLeft(four).setRight(five);
        three.setLeft(six);

        // list迭代器测试
        System.out.println("=====list的迭代开始=====");
        Iterator<Integer> listItr = list.iterator();
        while (listItr.hasNext()) {
            Integer next = listItr.next();
            System.out.printf("%s ", next);
        }
        System.out.println("\n=====list的迭代结束=====");

        // tree迭代器测试
        System.out.println("=====tree的迭代开始=====");
        Iterator<Tree> treeItr = one.iterator();
        while (treeItr.hasNext()) {
            Tree next = treeItr.next();
            System.out.printf("%s ", next.getValue());
        }
        System.out.println("\n=====tree的迭代结束=====");
    }
}

public interface Collect {
    Iterator iterator();
}

public class List<T> implements Collect {

    private Object[] arr = new Object[16];
    private int idx;
    private int size;

    @Override
    public Iterator iterator() {
        return new ListIterator(this);
    }

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

public interface Iterator<T> {
    boolean hasNext();
    T next();
}

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

public class TreeIterator implements Iterator<Tree> {

    private Tree tree;
    private Stack<Tree> stack = new Stack<>();

    public TreeIterator(Tree tree) {
        this.tree = tree;
        init(tree);
    }

    private void init(Tree tree) {
        if (tree.getRight() != null) {
            init(tree.getRight());
        }
        stack.push(tree);
        if (tree.getLeft() != null) {
            init(tree.getLeft());
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public Tree next() {
        if (stack.empty())
            throw new RuntimeException("无下一个元素！！！");
        return stack.pop();
    }
}
```

客户端中已经没有了List和Tree迭代的核心代码，取而代之的是几乎一模一样的两块while循环。这不仅解决了在客户端编写复杂核心代码的问题，还解决了List和Tree在客户端的迭代代码不同的问题。

## 总结

### 优点

- 对于不同的数据结构实现不同的迭代方式，并且增加新数据结构时只需要增加一个新的数据结构类即可，不需要修改原有的其它类。

- 客户端使用相同的迭代方法，减少客户端代码的复杂性。

### 缺点

- 对于数组、List等迭代简单的数据结构，使用迭代器模式其实也没有什么必要。

### 适用场景

- 复杂的数据结构迭代。