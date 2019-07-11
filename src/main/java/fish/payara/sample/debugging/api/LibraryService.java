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
    @Path("/{id}")
    public Library getLibrary(@PathParam("id") String name);

    @POST
    public Library addLibrary(@Valid Library library);

    @POST
    @Path("/{id}")
    public Book addBookToLibrary(@PathParam("id") String id, Book book);

    @DELETE
    @Path("/{id}/{bookId}")
    public Book removeBookFromLibrary(@PathParam("id") String id, @PathParam("bookId") String bookId);

    @PUT
    @Path("/{id}")
    public Library updateLibrary(@PathParam("id") String id, @Valid Library library);
}