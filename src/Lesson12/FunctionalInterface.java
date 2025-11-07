package Lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;
/**
 * задания из Functional Interface
 * */
public class FunctionalInterface {
    public void allTasks(){
        //task1
        //проверка на пустоту не нужна, т.к. пустая строка не может обладать длинной
        Predicate<String> predicate = s -> s.length() > 3;

        //task2
        Function<String, Integer> function = String::length;

        //task3
        Supplier<UUID> supplier = UUID::randomUUID;

        //task4
        Consumer<String> consumer = string -> System.out.println(string.toUpperCase());

        //task5
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;

        //task6
        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> result = trim.andThen(toUpperCase);

        //task7
        Consumer<String> printConsumer = System.out::println;
        Consumer<String> lengthPrinter = String::length;
        Consumer<String> bothConsumer = printConsumer.andThen(lengthPrinter);

        //task8
        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> isPositive = integer -> integer > 0;
        Predicate<Integer> unevenAndNegative = isEven.negate().and(isPositive.negate());

        //task9
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> unityFunction = multiply.andThen(toStr);

        //task10
        UnaryOperator<String> unaryOperator = string -> string.concat("!!!");
    }

    //task11
    public <T> List<T> filter(List<T> list, Predicate<T> predicate){
        return list.stream().filter(predicate).toList();
    }

    //task12
    public <T,R> List<R> map(List<T> list, Function<T, R> mapper){
        return list.stream().map(mapper).toList();
    }

    //task13
    public <T> void forEach(List<T> list, Consumer<T> consumer){
        /**
         * вот тут не понял. указано в задании - "напечатай каждый элемент списка"
         * consumer выводит на экран? или просто System.out.println сделать
         * */
        list.forEach(consumer);
    }

    //task14
    public <T> List<T> generate(Supplier<T> supplier, int n){
        List<T> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            result.add(supplier.get());
        }
        return result;
    }
}
