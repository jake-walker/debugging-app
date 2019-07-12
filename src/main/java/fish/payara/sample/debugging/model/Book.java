package fish.payara.sample.debugging.model;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * The book object.
 *
 * @author Matt Gill
 */
public class Book {
    private String id;

    private ZonedDateTime lastModified = ZonedDateTime.now();

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    /**
     * Gets the book's id.
     *
     * @return the id of the book
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the book's id.
     *
     * @param id the id of the book
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the book's name.
     *
     * @return the name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the book's name.
     *
     * @param name the name of the book
     */
    public void setName(String name) {
        this.name = name;
        this.updated();
    }

    /**
     * Gets the book's author.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the book's author.
     *
     * @param author the author of the book
     */
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
        return Objects.hash(id, name, author);
    }

    private void updated() {
        this.lastModified = ZonedDateTime.now();
    }

    /**
     * Gets last modified date of the book.
     *
     * @return the date that the book was last modified
     */
    public ZonedDateTime getLastModified() {
        return this.lastModified;
    }
}