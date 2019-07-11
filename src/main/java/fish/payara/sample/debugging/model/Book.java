package fish.payara.sample.debugging.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Matt Gill
 */
public class Book {
    private String id = "b-" + UUID.randomUUID().toString().substring(0, 5).toLowerCase();

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}