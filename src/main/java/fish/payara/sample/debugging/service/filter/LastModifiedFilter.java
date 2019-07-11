package fish.payara.sample.debugging.service.filter;

import fish.payara.sample.debugging.model.Book;
import fish.payara.sample.debugging.model.Library;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Provider
public class LastModifiedFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        ZonedDateTime lastModified = null;

        if (response.getEntityClass() == Library.class) {
            Library library = (Library) response.getEntity();
            lastModified = library.getLastModified();
        } else if (response.getEntityClass() == Book.class) {
            Book book = (Book) response.getEntity();
            lastModified = book.getLastModified();
        }


        if (lastModified != null) {
            DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
            String formattedDate = formatter.format(lastModified);
            if (!response.getHeaders().containsKey("Last-Modified")) {
                response.getHeaders().add("Last-Modified", formattedDate);
            }
        }
    }
}
