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
    public Collection<Book> getAllBooks();

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") String id);

    @POST
    public Book addBook(@Valid Book book);

    @PUT
    @Path("/{id}")
    public Book updateBook(@PathParam("id") String id, Book book);

    @DELETE
    @Path("/{id}")
    public Book removeBook(@PathParam("id") String id);
}