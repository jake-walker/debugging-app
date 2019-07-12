package fish.payara.sample.debugging.model;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * The library object.
 *
 * @author Matt Gill
 */
public class Library {
    private String id;

    private ZonedDateTime lastModified = ZonedDateTime.now();

    @NotBlank
    private String name;

    private Collection<Book> books;

    /**
     * Gets the library's id.
     *
     * @return the id of the library
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the library's id.
     *
     * @param id the id of the library
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the library's name.
     *
     * @return the name of the library
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the library's name.
     *
     * @param name the name of the library
     */
    public void setName(String name) {
        this.name = name;
        this.updated();

    }

    /**
     * Gets all the books in the library.
     *
     * @return the books in the library
     */
    public Collection<Book> getBooks() {
        return books;
    }

    /**
     * Add a book to the library.
     *
     * @param book the book to add
     */
    void addBook(Book book) {
        if (this.books == null) {
            this.books = new LinkedHashSet<>();
        }
        books.add(book);
        this.updated();
    }

    /**
     * Remove a book from the library.
     *
     * @param book the book to remove
     */
    void removeBook(Book book) {
        books.remove(book);
        this.updated();
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

    private void updated() {
        this.lastModified = ZonedDateTime.now();
    }

    /**
     * Gets the date that the library was last modified.
     *
     * @return the date the library was last modified
     */
    public ZonedDateTime getLastModified() {
        return this.lastModified;
    }
}