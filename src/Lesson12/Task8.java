package Lesson12;

import java.util.List;

public class Task8 {
    List<String> names = List.of("Tom", "Jerry", "Spike");
    String name = new String();

    public void convertIntoString(){
        StringBuilder sb = new StringBuilder();
        names.forEach(name -> sb.append(name).append(","));
        name = sb.toString();
    }

    public void convertIntoStringWithStream(){
        name = names
            .stream()
            .reduce((word1, word2) -> word1 + "," + word2)
            .orElse("");
    }
}
