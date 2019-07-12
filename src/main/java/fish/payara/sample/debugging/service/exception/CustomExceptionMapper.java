package fish.payara.sample.debugging.service.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static javax.ws.rs.core.MediaType.*;

/**
 * The type Custom exception mapper.
 *
 * @param <T> the type parameter
 * @author Matt Gill
 */
public abstract class CustomExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    private Set<MediaType> SUPPORTED_MEDIA_TYPES = new HashSet<>(asList(
        APPLICATION_JSON_TYPE, APPLICATION_XML_TYPE, TEXT_PLAIN_TYPE
    ));

    @Context
    private HttpHeaders headers;

    @Override
    public final Response toResponse(T exception) {
        return buildResponse(exception)
                .type(getPreferredMediaType())
                .build();
    }

    /**
     * Build response response builder.
     *
     * @param exception the exception
     * @return the response builder
     */
    protected abstract ResponseBuilder buildResponse(T exception);

    private MediaType getPreferredMediaType() {
        for (MediaType preference : headers.getAcceptableMediaTypes()) {
            if (SUPPORTED_MEDIA_TYPES.contains(preference)) {
                return preference;
            }
        }
        return APPLICATION_JSON_TYPE;
    }

}