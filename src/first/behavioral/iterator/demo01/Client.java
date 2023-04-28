package first.behavioral.iterator.demo01;

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
