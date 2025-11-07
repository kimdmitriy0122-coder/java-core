package Lesson11;


public class Subscriber implements Runnable {
    Monitor monitor;
    public Subscriber(Monitor monitor) {
        this.monitor = monitor;
    }
    @Override
    public void run() {
        System.out.println("Subscriber started");
        try {
            System.out.println(monitor.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
