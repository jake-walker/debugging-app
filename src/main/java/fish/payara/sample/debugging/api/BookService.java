package fish.payara.sample.debugging.api;

import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.*;

import fish.payara.sample.debugging.model.Book;

/**
 * @author Matt Gill
 */
public interface BookService {

    @GET
    Collection<Book> getAllBooks();

    @GET
    @Path("/{id}")
    Book getBook(@PathParam("id") String id);

    @POST
    Book addBook(@Valid Book book);

    @PUT
    @Path("/{id}")
    Book updateBook(@PathParam("id") String id, Book book);

    @DELETE
    @Path("/{id}")
    Book removeBook(@PathParam("id") String id);
}