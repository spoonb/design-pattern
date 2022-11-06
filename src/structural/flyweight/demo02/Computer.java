package structural.flyweight.demo02;

public class Computer {
   	private String sn; // 序列号，电脑的唯一识别码
    private ComputerSpec spec; // 依赖规格的具体属性 → 依赖ComputerSpec类，迪米特法则
    
    public Computer(String sn, ComputerSpec spec) {
        this.sn = sn;
        this.spec = spec;
    }
}