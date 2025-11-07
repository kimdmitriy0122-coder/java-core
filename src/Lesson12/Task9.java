package Lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task9 {
    List<String> sentences = List.of("Java is cool", "Streams are powerful");
    List<String> result = new ArrayList<>();

    public void convertIntoString(){
        sentences
            .forEach(sentence ->
                Collections.addAll(result, sentence.split("\\s")));
    }

    public void convertIntoStringWithSteam(){
        result = sentences
            .stream()
            .flatMap(sentence -> Arrays.stream(sentence.split("\\s")))
            .toList();
    }
}
