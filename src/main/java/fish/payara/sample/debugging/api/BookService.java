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
    @Path("/{name}")
    public Book getBook(@PathParam("name") String name);

    @POST
    public Book addBook(@Valid Book book);

    @PUT
    @Path("/{name}")
    public Book updateBook(@PathParam("name") String name, Book book);
}