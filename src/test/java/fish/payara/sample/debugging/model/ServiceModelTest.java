package fish.payara.sample.debugging.model;

import fish.payara.sample.debugging.TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for the overall service model
 */
public class ServiceModelTest {
    private ServiceModel model = new ServiceModel();
    private Library library;

    /**
     * Prepare model.
     */
    @Before
    public void prepareModel() {
        // Create a library
        this.library = new Library();
        library.setName("Test Library");
        library.setId("123456");
        this.model.getLibraries().add(library);
    }

    /**
     * Test that a new book added to library is added to library.
     */
    @Test
    public void newBookAddedToLibraryIsAddedToLibrary() {
        String bookName = TestUtils.generateString();

        // Create a new book
        Book book = new Book();
        book.setName(bookName);

        // Add the book to a library
        this.model.addBook(this.library, book);

        // Check the book is contained in the library
        assertTrue(this.library.getBooks().contains(book));
    }

    /**
     * Test that a new book added to library is added to global list too.
     */
    @Test
    public void newBookAddedToLibraryIsAddedToGlobalList() {
        String bookName = TestUtils.generateString();

        // Create a new book
        Book book = new Book();
        book.setName(bookName);

        // Add the book to a library
        this.model.addBook(this.library, book);

        // Check the book is contained in the library
        assertTrue(this.model.getBooks().contains(book));
    }

    /**
     * Test that a new book added to the global list is in global list.
     */
    @Test
    public void newBookAddedToGlobalListIsInGlobalList() {
        String bookName = TestUtils.generateString();

        // Create a new book
        Book book = new Book();
        book.setName(bookName);

        // Add the book
        this.model.addBook(book);

        // Check the book is contained in the library
        assertTrue(this.model.getBooks().contains(book));
    }
}