package fish.payara.sample.debugging.model;

import fish.payara.sample.debugging.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void setId() {
        String testString = TestUtils.generateString();
        Library library = new Library();
        library.setId(testString);
        assertEquals(testString, library.getId());
    }

    @Test
    public void setName() {
        String testString = TestUtils.generateString();
        Library library = new Library();
        library.setName(testString);
        assertEquals(testString, library.getName());
    }

    /*@Test
    public void lastModified() throws InterruptedException {
        Library library = new Library();
        ZonedDateTime time1 = library.getLastModified();
        library.setId("2");
        TimeUnit.SECONDS.sleep(1);
        ZonedDateTime time2 = library.getLastModified();
        assertTrue(time1.isBefore(time2));
    }*/
}