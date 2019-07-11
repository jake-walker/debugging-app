package fish.payara.sample.debugging.model;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Matt Gill
 */
public class Book {
    private String id;

    private ZonedDateTime lastModified = ZonedDateTime.now();

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    public Book() {
        this(null, null);
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = "b-" + UUID.randomUUID().toString().substring(0, 5).toLowerCase();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updated();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        this.updated();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }

    private void updated() {
        this.lastModified = ZonedDateTime.now();
    }

    public ZonedDateTime getLastModified() {
        return this.lastModified;
    }
}