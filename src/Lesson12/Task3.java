package Lesson12;

import java.util.List;

public class Task3 {
    public void minMaxSearching(){
        /**
         * тут в задании написано найти именно через Stream Api.
         * не стал делать через for.
         * не бейте, пожалуйста)
         * */
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        System.out.println(nums.stream().max(Integer::compareTo).orElse(0));
        System.out.println(nums.stream().min(Integer::compareTo).orElse(0));
    }
}
