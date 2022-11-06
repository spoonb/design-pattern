package behavioral.observer.demo01;

public class Server {

    private double cpu;
    private double memory;
    private double disk;
    private double gpu;

    public void startServer() {
        this.cpu = 15;
        this.memory = 20;
        this.disk = 10;
        this.gpu = 5;
    }

    public void startASoft() {
        this.cpu += 15;
        this.memory += 20;
        this.disk += 10;
        this.gpu += 15;
    }

    public void stopASoft() {
        this.cpu -= 15;
        this.memory -= 20;
        this.disk -= 10;
        this.gpu -= 15;
    }

    public double getCpu() {
        return cpu;
    }

    public double getMemory() {
        return memory;
    }

    public double getDisk() {
        return disk;
    }

    public double getGpu() {
        return gpu;
    }
}
