package fish.payara.sample.debugging.model;

import fish.payara.sample.debugging.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void setId() {
        String testString = TestUtils.generateString();
        Book book = new Book();
        book.setId(testString);
        assertEquals(testString, book.getId());
    }

    @Test
    public void setName() {
        String testString = TestUtils.generateString();
        Book book = new Book();
        book.setName(testString);
        assertEquals(testString, book.getName());
    }
}