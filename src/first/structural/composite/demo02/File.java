package first.structural.composite.demo02;

import java.util.List;

public class File implements Node {
    private String path;
    private Node parent;
    
    public File(Node parent, String path) {
        if (parent == null)
            throw new RuntimeException("输入的dir不正确！");
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.parent = parent;
        this.path = parent.getPath() + path;
        parent.add(this);
    }
    
    public boolean add(Node node) { // 因为不是容器，所以重写这个方法无意义
        throw new RuntimeException("不支持此方法!");
    }
    
    public boolean remove(Node node) { // 同上
        throw new RuntimeException("不支持此方法!");
    }
    
    public List<Node> getChildren() { // 同上
        throw new RuntimeException("不支持此方法!");
    }
    
    public String getPath() {
        return this.path;
    }
}