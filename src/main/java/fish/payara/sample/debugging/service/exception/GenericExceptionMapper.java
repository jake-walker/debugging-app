package fish.payara.sample.debugging.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The exception mapper for catching all other exceptions.
 *
 * @author Jake Walker
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ServiceError(exception)).build();
    }
}
