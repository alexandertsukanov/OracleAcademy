package oracleacademy.tsukanov.task6.bookutility;

import java.io.File;
import java.io.IOException;

import static oracleacademy.tsukanov.task6.bookutility.BookUtility.*;

public class Demo {
        public static void main(String args[]) throws IOException {
          File file = new File("additional/books.txt");
          bookFromFile(file).forEach(book -> System.out.println(book.getAuthor() + " " + book.getTitle() + " " + book.getYear()));
          bookToFile("additional/books_saved.txt");
    }
}
