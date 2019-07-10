package fish.payara.sample.debugging.api;

import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.*;

import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.Library;

/**
 * @author Matt Gill
 */
public interface LibraryService {

    @GET
    public Collection<Library> getAllLibraries();

    @GET
    @Path("/{name}")
    public Library getLibrary(@PathParam("name") String name);

    @POST
    public Library addLibrary(@Valid Library library);

    @POST
    @Path("/{name}")
    public Book addBookToLibrary(@PathParam("name") String name, Book book);

    @DELETE
    @Path("/{name}/{bookName}")
    public Book removeBookFromLibrary(@PathParam("name") String name, @PathParam("bookName") String bookName);
}