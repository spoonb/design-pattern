package structural.composite.demo01;

public class File { // 文件类
    private String path;
    private Directory parent;
    
    public File(Directory dir, String path) {
        if (dir == null)
            throw new RuntimeException("输入的dir不正确！");
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.parent = dir;
        this.path = dir.getPath() + path;
        dir.add(this);
    }
    
    public String getPath() {
        return this.path;
    }
}