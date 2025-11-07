package Lesson08;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntegerParsing {
    private String originalString;
    private Scanner scanner;

    public void input(){
        System.out.println("начните ввод");
        scanner = new Scanner(System.in).useDelimiter(" ");
        Set<Integer> integerSet = new HashSet<>();
        while(scanner.hasNextInt()){
            integerSet.add(scanner.nextInt());
        }
    }
}
