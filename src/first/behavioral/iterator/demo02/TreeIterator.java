package first.behavioral.iterator.demo02;

import java.util.Stack;

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
