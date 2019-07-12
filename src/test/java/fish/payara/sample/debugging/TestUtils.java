package fish.payara.sample.debugging;

import java.util.UUID;

/**
 * Extra methods used in tests
 */
public class TestUtils {
    /**
     * Generate a random string.
     *
     * @return the random string
     */
    public static String generateString() {
        // Generate a UUID and strip all special characters
        return UUID.randomUUID().toString()
                .replaceAll("[^a-zA-Z0-9]", "");
    }
}
