package fish.payara.sample.debugging.service.exception;

/**
 * A Service error object.
 *
 * @author Matt Gill
 */
public class ServiceError {

    private String type;
    private String message;
    private String[] details;

    /**
     * Instantiates a new Service error.
     *
     * @param errorType the error type
     * @param message   the error message
     * @param details   the error details
     */
    protected <T extends Throwable> ServiceError(Class<T> errorType, String message, String... details) {
        this.type = errorType.getSimpleName();
        this.message = message;
        this.details = details;
    }

    /**
     * Instantiates a new Service error.
     *
     * @param throwable the throwable
     */
    protected ServiceError(Throwable throwable) {
        this(throwable.getClass(), throwable.getMessage());
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get details string [ ].
     *
     * @return the string [ ]
     */
    public String[] getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String[] details) {
        this.details = details;
    }

}