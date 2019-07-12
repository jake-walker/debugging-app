package fish.payara.sample.debugging.model;

import fish.payara.sample.debugging.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for book objects.
 *
 * @author Jake Walker
 */
public class BookTest {
    /**
     * Test setting an ID on a book and making sure it is returned properly.
     */
    @Test
    public void setId() {
        String testString = TestUtils.generateString();
        Book book = new Book();
        book.setId(testString);
        assertEquals(testString, book.getId());
    }

    /**
     * Test setting a name on a book and making sure it is returned properly.
     */
    @Test
    public void setName() {
        String testString = TestUtils.generateString();
        Book book = new Book();
        book.setName(testString);
        assertEquals(testString, book.getName());
    }
}