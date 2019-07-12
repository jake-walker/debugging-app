package fish.payara.sample.debugging.service;

import fish.payara.sample.debugging.api.LibraryService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * The type Library endpoints test.
 */
@RunWith(MockitoJUnitRunner.class)
public class LibraryEndpointsTest {
    private LibraryEndpoints endpoints;
    private LibraryService service;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        this.endpoints = new LibraryEndpoints();
        this.service = mock(LibraryService.class);
    }


}