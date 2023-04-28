package first.structural.composite.demo02;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Node {
    private String path;
    private List<Node> children = new ArrayList<>();
    
    public Directory(String path) {
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.path = path;
    }
    
    public Directory(Node parent, String path) {
        if (parent == null)
            throw new RuntimeException("输入的parent不正确！");
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.path = parent.getPath() + path;
        parent.add(this);
    }
    
    public boolean add(Node target) {
        for (Node node : children)
            // 不能创建同名文件
            if (target.getPath().equals(node.getPath())) return false;
        children.add(target);
        return true;
    }
    
    public boolean remove(Node target) {
        for (Node node : children)
            if (target.getPath().equals(node.getPath())) {
                children.remove(node);
                return true;
            }
        return false;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public List<Node> getChildren() {
        return this.children;
    }
}