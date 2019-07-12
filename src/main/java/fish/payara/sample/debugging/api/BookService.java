package fish.payara.sample.debugging.api;

import fish.payara.sample.debugging.model.Book;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.Collection;

/**
 * The interface for book API endpoints.
 *
 * @author Matt Gill
 */
public interface BookService {

    /**
     * Endpoint for getting all books across all libraries.
     *
     * @return all books across all libraries
     */
    @GET
    Collection<Book> getAllBooks();

    /**
     * Endpoint for getting one book by it's ID.
     *
     * @param id the ID of the book
     * @return the book
     */
    @GET
    @Path("/{id}")
    Book getBook(@PathParam("id") String id);

    /**
     * Add a book to the 'global' list.
     *
     * @param book the book to add
     * @return the book that was created
     */
    @POST
    Book addBook(@Valid Book book);

    /**
     * Update an existing book's information by it's ID.
     *
     * @param id   the ID of the book to update
     * @param book a book object with properties to be applied to the main book ID
     * @return the updated book
     */
    @PUT
    @Path("/{id}")
    Book updateBook(@PathParam("id") String id, Book book);

    /**
     * Remove book from the 'global' list by it's ID.
     *
     * @param id the id of the book to remove
     * @return the book that was removed
     */
    @DELETE
    @Path("/{id}")
    Book removeBook(@PathParam("id") String id);
}