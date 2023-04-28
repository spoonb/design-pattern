package first.behavioral.strategy.demo03;

// 上下文类，根据客户端业务的需求持有不同的计算对象
public class Context {
    private Trans trans;
    
    public Context(Trans trans) {
       	this.trans = trans;
    }
    
    // 更改持有的交通方式
    public void change(Trans trans) {
        this.trans = trans;
    }
    
    // 实际调用持有的trans实现
    public void toTarget(String target) {
        trans.toTarget(target);
    }
}