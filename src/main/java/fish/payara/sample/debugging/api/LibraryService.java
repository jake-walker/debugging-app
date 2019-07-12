package fish.payara.sample.debugging.api;

import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.Library;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.Collection;


/**
 * The interface for library API endpoints.
 * 
 * @author Matt Gill
 */
public interface LibraryService {

    /**
     * Gets all libraries.
     *
     * @return all the libraries
     */
    @GET
    Collection<Library> getAllLibraries();

    /**
     * Gets a single library by it's ID.
     *
     * @param id the ID of the library to get
     * @return the library
     */
    @GET
    @Path("/{id}")
    Library getLibrary(@PathParam("id") String id);

    /**
     * Add a library.
     *
     * @param library the library to add
     * @return the library that was added
     */
    @POST
    Library addLibrary(@Valid Library library);

    /**
     * Add book to library.
     *
     * @param id   the id of the library
     * @param book the book object to add (needs ID)
     * @return the book that was added
     */
    @POST
    @Path("/{id}")
    Book addBookToLibrary(@PathParam("id") String id, Book book);

    /**
     * Remove book from a library.
     *
     * @param id     the id of the library
     * @param bookId the book id of the book to remove
     * @return the book
     */
    @DELETE
    @Path("/{id}/{bookId}")
    Book removeBookFromLibrary(@PathParam("id") String id, @PathParam("bookId") String bookId);

    /**
     * Update library information.
     *
     * @param id      the id of the library to update
     * @param library a library object with properties that will be applied
     * @return the updated library
     */
    @PUT
    @Path("/{id}")
    Library updateLibrary(@PathParam("id") String id, @Valid Library library);
}