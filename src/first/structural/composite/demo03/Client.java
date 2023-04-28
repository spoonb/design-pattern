package first.structural.composite.demo03;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 创建各级目录
        Directory root = new Directory("/root");
        Directory home = new Directory(root, "/home");
        Directory user1 = new Directory(home, "/user1");
        Directory text = new Directory(user1, "/text");
        Directory image = new Directory(user1, "/image");
        Directory png = new Directory(image, "/png");
        Directory gif = new Directory(image, "/gif");
        // 创建文件
        File f1 = new File(text, "/f1.txt");
        File f2 = new File(text, "/f2.txt");
        File f3 = new File(png, "/f3.png");
        File f4 = new File(gif, "/f4.gif");
        File f5 = new File(png, "/f5.png");
        // 输出root下的文件或者目录路径
        print(root);
    }
    
    public static void print(Directory root) {
        System.out.println(root.getPath());
        List<Node> nodes = root.getChildren();
        for (int i = 0; i < nodes.size(); i ++) {
            Node node = nodes.get(i);
            if (nodes.get(i) instanceof File) {
                System.out.println(node.getPath());
                continue;
            }
            print((Directory) node); // 增加强转
        }
    }
}