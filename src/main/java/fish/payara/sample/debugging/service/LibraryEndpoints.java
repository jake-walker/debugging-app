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
    public Library getLibrary(String name) {
        return model.getLibraries().stream()
                .filter(library -> library.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the library with the specified name."));
    }

    public Book getBook(String name) {
        return model.getBooks().stream()
                .filter(book -> book.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Unable to find the book with the specified name."));
    }

    @Override
    public Library addLibrary(Library library) {
        model.getLibraries().add(library);
        return library;
    }

    @Override
    public Book addBookToLibrary(String name, Book book) {
        Library library = getLibrary(name);
        model.addBook(library, book);
        return book;
    }

    @Override
    public Book removeBookFromLibrary(String name, String bookName) {
        Library library = getLibrary(name);
        Book book = getBook(bookName);
        model.removeBook(library, book);
        return book;
    }

    @Override
    public Library updateLibrary(String name, Library library) {
        Library libraryToUpdate = getLibrary(name);

        if (library.getName() != null) {
            libraryToUpdate.setName(library.getName());
        }

        return libraryToUpdate;
    }
}