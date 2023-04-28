package first.structural.flyweight.demo01;

public class Computer {
   	private String sn; // 序列号，电脑的唯一识别码
    private String brand; // 品牌
    private String title; // 一个系列的名称，如Lenovo的Thinkpad
    private String cpu;
    private String memory;
    private String disk;
    private String gpu;
    private String keyboard;
    private String display;
    
    public Computer(String sn, String brand, 
                    String title, String cpu, 
                    String memory, String disk, 
                    String gpu, String keyboard, 
                    String display) {
        this.sn = sn;
        this.brand = brand;
        this.title = title;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.gpu = gpu;
        this.keyboard = keyboard;
        this.display = display;
    }
}