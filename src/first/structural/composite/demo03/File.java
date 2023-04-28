package first.structural.composite.demo03;

public class File implements Node {
    private String path;
    private Node parent;
    
    public File(Directory parent, String path) {
        if (parent == null)
            throw new RuntimeException("输入的dir不正确！");
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.parent = parent;
        this.path = parent.getPath() + path;
        parent.add(this);
    }
    
    public String getPath() {
        return this.path;
    }
}