package first.structural.flyweight.demo02;

public enum ComputerSpec { // 定义一个计算机规格类
    MATEBOOK16("华为", "MateBook16", "锐龙7 5800H标压",
               "16GB DDR4 双通道", "512GB NVMe PCle SSD", 
               "gpu", "全尺寸背光键盘", "16英寸");
    
    public String brand; // 品牌
    public String title; // 一个系列的名称，如Lenovo的Thinkpad
    public String cpu;
    public String memory;
    public String disk;
    public String gpu;
    public String keyboard;
    public String display;
    
    ComputerSpec(String brand,
                 String title, String cpu,
                 String memory, String disk,
                 String gpu, String keyboard,
                 String display) {
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