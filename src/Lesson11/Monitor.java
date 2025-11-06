package Lesson11;

import lombok.Data;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

@Data
public class Monitor {
    private ArrayBlockingQueue<String> words = new ArrayBlockingQueue<>(20);
    private Scanner scanner = new Scanner(System.in);

    public void put() {
        System.out.println("введите слово. стоп слово - \"exit\"");
        String word = scanner.nextLine();
        while(!word.equals("exit")) {
            words.offer(word);
            word = scanner.nextLine();
        }
    }

    public String take() throws InterruptedException {
        return words.take();
    }
}
