package fish.payara.sample.debugging.api;

import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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

}