package lesson03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OnlineStore {
    private String name;
    private int code, price;
    private static int count = 0;
    private static final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        count++;
        products.add(product);
    }
    public void addProduct(int code, int price, String name) {
        count++;
        products.add(new Product(name, code, price));
    }
    public void buyProduct(Product product){
        if(count == 0)
            throw new NoProductsAvailableException();
        count--;
        products.remove(product);
    }
    public void buyProduct(int code) {
        if(count == 0)
            throw new NoProductsAvailableException();
        count--;
        products.removeIf(product -> product.getCode() == code);
    }
    public Product getProductInfo(int code) {
        /**
         * getProductInfo с параметром Product не нужен, т.к. тогда можно просто sout(product)
         * */
        return products.stream().filter(product -> product.getCode() == code).findFirst().get();
    }


    @Data
    @AllArgsConstructor
    class Product{
        private String name;
        private int price, code;
    }

    class NoProductsAvailableException extends RuntimeException {
        private String message = "No products available";
    }
}