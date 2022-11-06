package structural.composite.demo02;

import java.util.List;

public interface Node { // 从File和Directory中抽象出Node类
    boolean add(Node node);
    boolean remove(Node node);
    List<Node> getChildren();
    String getPath();
}