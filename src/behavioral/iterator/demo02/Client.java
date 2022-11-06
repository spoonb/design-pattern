package behavioral.iterator.demo02;

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
