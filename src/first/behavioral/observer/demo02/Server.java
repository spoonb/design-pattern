package first.behavioral.observer.demo02;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private double cpu;
    private double memory;
    private double disk;
    private double gpu;

    private List<Observer> obs = new ArrayList<>();

    public void startServer() {
        this.cpu = 15;
        this.memory = 20;
        this.disk = 10;
        this.gpu = 5;
        update();
    }

    public void startASoft() {
        this.cpu += 15;
        this.memory += 20;
        this.disk += 10;
        this.gpu += 15;
        update();
    }

    public void stopASoft() {
        this.cpu -= 15;
        this.memory -= 20;
        this.disk -= 10;
        this.gpu -= 15;
        update();
    }

    public void addOb(Observer ob) {
        obs.add(ob);
    }

    private void update() {
        for (Observer ob : obs) {
            ob.update();
        }
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
