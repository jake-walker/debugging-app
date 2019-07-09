package fish.payara.sample.debugging.model;

import javax.validation.constraints.NotBlank;

/**
 * @author Matt Gill
 */
public class Book {

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    public Book() {}

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
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