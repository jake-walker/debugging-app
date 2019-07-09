package fish.payara.sample.debugging.model;

import static java.util.Collections.unmodifiableCollection;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Matt Gill
 */
@ApplicationScoped
public class ServiceModel {

    private Collection<Book> books;
    private Collection<Library> libraries;

    public ServiceModel() {
        this.books = new LinkedHashSet<>();
        this.libraries = new LinkedHashSet<>();
    }

    public Collection<Book> getBooks() {
        return unmodifiableCollection(books);
    }

    public Collection<Library> getLibraries() {
        return libraries;
    }

    public Book addBook(Library library, Book book) {
        library.addBook(book);
        return addBook(book);
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

}