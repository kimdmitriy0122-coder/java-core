package Lesson12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task10 {
    record Product(String name, String category, double price) {}
    List<Product> products = List.of(
        new Product("Phone", "Electronics", 1200),
        new Product("TV", "Electronics", 1800),
        new Product("Apple", "Fruits", 2.5),
        new Product("Mango", "Fruits", 4.0));
    Map<String, Product> mostExpensiveProduct = new HashMap();

    public void mostExpensiveProductByCategory() {
        products.forEach(product ->
            mostExpensiveProduct.put(product.category, product));
    }

    public void mostExpensiveProductByCategoryWithStream(){
        mostExpensiveProduct = products
            .stream()
            .collect(Collectors.toMap(
                product -> product.category,
                product -> product));
    }
}
