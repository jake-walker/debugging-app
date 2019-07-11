package fish.payara.sample.debugging.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;

import fish.payara.sample.debugging.api.LibraryService;
import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.Library;
import fish.payara.sample.debugging.model.ServiceModel;

/**
 * @author Matt Gill
 */
@RequestScoped
@Path("/libraries")
public class LibraryEndpoints implements LibraryService {

    @Inject
    private ServiceModel model;

    @Override
    public Collection<Library> getAllLibraries() {
        return model.getLibraries();
    }

    @Override
    public Library getLibrary(String id) {
        return model.getLibraries().stream()
                .filter(library -> library.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the library with the specified ID."));
    }

    public Book getBook(String id) {
        return model.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the book with the specified ID."));
    }

    @Override
    public Library addLibrary(Library library) {
        model.getLibraries().add(library);
        return library;
    }

    @Override
    public Book addBookToLibrary(String id, Book book) {
        Library library = getLibrary(id);
        model.addBook(library, book);
        return book;
    }

    @Override
    public Book removeBookFromLibrary(String id, String bookId) {
        Library library = getLibrary(id);
        Book book = getBook(bookId);
        model.removeBook(library, book);
        return book;
    }

    @Override
    public Library updateLibrary(String id, Library library) {
        Library libraryToUpdate = getLibrary(id);

        if (library.getName() != null) {
            libraryToUpdate.setName(library.getName());
        }

        return libraryToUpdate;
    }

    @Override
    public Book addExistingBookToLibrary(String id, String bookId) {
        Library library = getLibrary(id);
        Book book = getBook(bookId);
        model.addBook(library, book);
        return book;
    }
}