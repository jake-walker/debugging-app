package fish.payara.sample.debugging.model;

import static java.util.Collections.unmodifiableCollection;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.enterprise.context.ApplicationScoped;

/**
 * The service model for managing libraries and books.
 *
 * @author Matt Gill
 */
@ApplicationScoped
public class ServiceModel {

    private Collection<Book> books;
    private Collection<Library> libraries;

    /**
     * Instantiates a new Service model.
     */
    public ServiceModel() {
        // Create a new list for books
        this.books = new LinkedHashSet<>();
        // Create a new list for libraries
        this.libraries = new LinkedHashSet<>();
    }

    /**
     * Gets the 'global' list of books.
     *
     * @return the list of all books
     */
    public Collection<Book> getBooks() {
        return unmodifiableCollection(books);
    }

    /**
     * Gets a list of all the libraries.
     *
     * @return the list of all libraries
     */
    public Collection<Library> getLibraries() {
        return libraries;
    }

    /**
     * Add a book to a library.
     *
     * @param library the library to add the book to
     * @param book    the book to add
     * @return the book that was added
     */
    public Book addBook(Library library, Book book) {
        // Add the book to the library
        library.addBook(book);
        // Add the book to the 'global' list
        return addBook(book);
    }

    /**
     * Add a book to the 'global' list.
     *
     * @param book the book to add
     * @return the book that was added
     */
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    /**
     * Remove a book from a library.
     *
     * @param library the library to remove the book from
     * @param book    the book to be removed
     * @return the book that was removed
     */
    public Book removeBook(Library library, Book book) {
        // Remove the book from the library
        library.removeBook(book);
        // Remove the book from the 'global' list
        return removeBook(book);
    }

    /**
     * Remove a book from the 'global' list.
     *
     * @param book the book to be removed
     * @return the book that was removed
     */
    public Book removeBook(Book book) {
        books.remove(book);
        return book;
    }
}