package Lesson12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task7 {
    List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
    Map<Character, List<String>> output = new HashMap<>();

    public void groupByFirstLetter() {
        for (String name : names) {
            char firstLetter = name.charAt(0);
            if(output.containsKey(firstLetter))
                output.get(firstLetter).add(name);
            else{
                List<String> list = new ArrayList<>();
                list.add(name);
                output.put(firstLetter, list);
            }
        }
    }

    public void groupByFirstLetterWithStream(){
        output = names
            .stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0)));
    }
}
