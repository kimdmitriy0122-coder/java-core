package Lesson08;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Books {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.isbn, book);
    }

    public void showBooks() {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Data
    class Book{
        private String name, author, isbn;
    }
}
