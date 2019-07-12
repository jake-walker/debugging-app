package fish.payara.sample.debugging.service.filter;

import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.Library;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The filter for adding a last modified header.
 * <i>Called a the <b>end</b> of a request.</i>
 */
@Provider
public class LastModifiedFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        ZonedDateTime lastModified = null;

        // If the response is a library object
        if (response.getEntityClass() == Library.class) {
            // Get the library object
            Library library = (Library) response.getEntity();
            lastModified = library.getLastModified();
            // If the response is a book object
        } else if (response.getEntityClass() == Book.class) {
            // Get the book object
            Book book = (Book) response.getEntity();
            lastModified = book.getLastModified();
        }

        // If a last modified date was found
        if (lastModified != null) {
            DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
            String formattedDate = formatter.format(lastModified);

            // Check that we have haven't already set the header
            if (!response.getHeaders().containsKey("Last-Modified")) {
                response.getHeaders().add("Last-Modified", formattedDate);
            }
        }
    }
}
