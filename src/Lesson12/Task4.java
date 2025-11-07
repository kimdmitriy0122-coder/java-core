package Lesson12;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task4 {
    private List<String> names = List.of("Alice", "Bob", "Charlie", "David");
    public double averageLengthSearch(){
        AtomicInteger lengthSum = new AtomicInteger();
        names.forEach(name -> lengthSum.getAndAdd(name.length()));
        return (double) lengthSum.get() / names.size();
    }

    public double averageLengthSearchWithStream(){
        AtomicInteger lengthSum = new AtomicInteger();
        names.stream().map(String::length).forEach(lengthSum::getAndAdd);
        return (double) lengthSum.get() / names.size();
    }
}
