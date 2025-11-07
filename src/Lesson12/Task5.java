package Lesson12;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task5 {
    private List<String> input = List.of("apple", "pear", "apple", "banana", "pear");

    public void distinctAndSort(){
        Set<String> unique = new HashSet<>(input);
        /**
         * или, если нужно прям
         * input.forEach(word -> unique.add(word));
         * */
        input.clear();
        Collections.addAll(unique);
        input.sort((word1, word2) -> word1.length() - word2.length() > 0 ? 1 : -1);
    }

    public void distinctAndSortWithStream(){
        input = input.stream()
            .distinct()
            .sorted((word1, word2) -> word1.length() - word2.length() > 0 ? 1 : -1)
            .toList();
    }
}
