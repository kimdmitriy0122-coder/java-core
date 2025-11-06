package lesson03;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    private String name, author,  status, isbn;
    private int year;
    private static final List<Book> BOOK_LIST = new ArrayList<>();

    public void getBookInfo(){
        System.out.println("name: " + name + " author: " + author + " status: " + status + " isbn: " + isbn + " year: " + year);
    }
    public static List<Book> getBooks(){
        return BOOK_LIST;
    }
    public static void addNewBook(Book book){
        BOOK_LIST.add(book);
    }
    public void reserveBook(){
        this.status = "RESERVED";
    }
}
