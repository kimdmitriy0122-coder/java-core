package Lesson12;

import java.util.List;

public class Task1 {
    private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    public void onlyOddLeftAndSquare(){
        numbers.removeIf(number -> number % 2 != 0);
        /**
         *  это на случай, если прям нужно через for
         *
         *  for(Integer number : numbers){
         *             if(number % 2 != 0){
         *                 numbers.remove(number);
         *             }
         *         }
         * */
    }

    public void onlyOddLeftAndSquareWithStream(){
        numbers = numbers.stream().filter(number -> number % 2 == 0).toList();
    }
}
