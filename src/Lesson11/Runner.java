package Lesson11;

public class Runner {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Thread publisher = new Thread(new Publisher(monitor));
        Thread subscriber = new Thread(new Subscriber(monitor));
        publisher.start();
        subscriber.start();
    }
}
