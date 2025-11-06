package Lesson12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    List<String> fruits = List.of("apple", "banana", "kiwi");
    Map<String, Integer> map = new HashMap<>();

    public void rebuildToMap(){
        fruits.forEach(value -> map.put(value, value.length()));
    }

    public void rebuildToMapWithStream(){
        map = fruits
            .stream()
            .collect(Collectors.toMap(value -> value, String::length));

    }
}
