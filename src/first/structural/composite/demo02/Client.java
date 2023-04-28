package first.structural.composite.demo02;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 创建各级目录
        Node root = new Directory("/root");
        Node home = new Directory(root, "/home");
        Node user1 = new Directory(home, "/user1");
        Node text = new Directory(user1, "/text");
        Node image = new Directory(user1, "/image");
        Node png = new Directory(image, "/png");
        Node gif = new Directory(image, "/gif");
        // 创建文件
        Node f1 = new File(text, "/f1.txt");
        Node f2 = new File(text, "/f2.txt");
        Node f3 = new File(png, "/f3.png");
        Node f4 = new File(gif, "/f4.gif");
        Node f5 = new File(png, "/f5.png");
        // 输出root下的文件或者目录路径
        print(root);
    }
    
    public static void print(Node root) {
        System.out.println(root.getPath());
        List<Node> nodes = root.getChildren();
        for (int i = 0; i < nodes.size(); i ++) {
            Node node = nodes.get(i);
            if (node instanceof File) {
                System.out.println(node.getPath());
                continue;
            }
            print(node);
        }
    }
}