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
    public Book getBook(String id) {
        return model.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the book with the specified ID."));
    }

    @Override
    public Book addBook(Book book) {
        return model.addBook(book);
    }


    @Override
    public Book updateBook(String id, Book book) {
        Book bookToUpdate = getBook(id);

        if (book.getName() != null) {
            bookToUpdate.setName(book.getName());
        }

        if (book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }

        return bookToUpdate;
    }

    @Override
    public Book removeBook(String id) {
        Book book = getBook(id);
        return model.removeBook(book);
    }
}