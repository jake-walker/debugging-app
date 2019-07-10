package fish.payara.sample.debugging.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.validation.constraints.NotBlank;

/**
 * @author Matt Gill
 */
public class Library {

    @NotBlank
    private String name;

    private Collection<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedHashSet<>();
    }

    public Library() {
        this(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    protected void addBook(Book book) {
        books.add(book);
    }

    protected void removeBook(Book book) {
        books.remove(book);
    }
}