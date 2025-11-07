package Lesson11;

import java.util.Scanner;

public class Publisher implements Runnable {
    Monitor monitor;
    private static Scanner scanner = new Scanner(System.in);

    public Publisher(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println("publisher started");
        monitor.put();
    }
}
