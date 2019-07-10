package fish.payara.sample.debugging.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;

import fish.payara.sample.debugging.api.BookService;
import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.ServiceModel;

/**
 * @author Matt Gill
 */
@RequestScoped
@Path("/books")
public class BookEndpoints implements BookService {

    @Inject
    private ServiceModel model;

    @Override
    public Collection<Book> getAllBooks() {
        return model.getBooks();
    }

    @Override
    public Book getBook(String name) {
        return model.getBooks().stream()
                .filter(book -> book.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the book with the specified name."));
    }

    @Override
    public Book addBook(Book book) {
        return model.addBook(book);
    }


    @Override
    public Book updateBook(String name, Book book) {
        Book bookToUpdate = getBook(name);

        if (book.getName() != null) {
            bookToUpdate.setName(book.getName());
        }

        if (book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }

        return bookToUpdate;
    }
}