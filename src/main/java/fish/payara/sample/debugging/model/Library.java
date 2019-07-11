package fish.payara.sample.debugging.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

/**
 * @author Matt Gill
 */
public class Library {
    private String id = "l-" + UUID.randomUUID().toString().substring(0, 5).toLowerCase();

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

    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) &&
                Objects.equals(name, library.name) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }
}