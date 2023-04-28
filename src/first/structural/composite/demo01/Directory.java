package first.structural.composite.demo01;

import java.util.ArrayList;
import java.util.List;

public class Directory { // 目录类
    private String path;
    private List<Directory> dirs = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    
    public Directory(String path) {
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.path = path;
    }
    
    public Directory(Directory parent, String path) {
        if (parent == null)
            throw new RuntimeException("输入的parent不正确！");
        if (path == null || path == "")
            throw new RuntimeException("输入的path不正确！");
        this.path = parent.getPath() + path;
        parent.add(this);
    }
    
    public boolean add(File target) {
        for (File file : files)
            // 不能创建同名文件
            if (target.getPath().equals(file.getPath())) return false;
        files.add(target);
        return true;
    }
    
    public boolean add(Directory target) {
        for (Directory dir : dirs)
            // 不能创建同名目录
            if (target.getPath().equals(dir.getPath())) return false;
        dirs.add(target);
        return true;
    }
    
    public boolean remove(Directory target) {
        for (Directory dir : dirs)
            if (target.getPath().equals(dir.getPath())) {
                dirs.remove(dir);
                return true;
            }
        return false;
    }
    
    public boolean remove(File target) {
        for (File file : files)
            if (target.getPath().equals(file.getPath())) {
                files.remove(file);
                return true;
            }
        return false;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public List<Directory> getDirs() {
        return this.dirs;
    }
    
    public List<File> getFiles() {
        return this.files;
    }
}