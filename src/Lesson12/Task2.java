package Lesson12;

import java.util.List;

public class Task2 {
    private List<String> words = List.of("apple", "banana", "pear", "pineapple");
    public void longerThanFive(){
        int counter = 0;
        for(String word : words){
            if(word.length() > 5){
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void longerThanFiveWithStream(){
        long counter = words.stream().filter(word -> word.length() > 5).count();
        System.out.println(counter);
    }
}
