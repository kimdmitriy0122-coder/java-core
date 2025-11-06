package lesson03;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I'm " + age + " years old.");
    }
}
