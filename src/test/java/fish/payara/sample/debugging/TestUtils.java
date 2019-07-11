package fish.payara.sample.debugging;

import java.util.UUID;

public class TestUtils {
    public static String generateString() {
        return UUID.randomUUID().toString()
                .replaceAll("[^a-zA-Z0-9]", "");
    }
}
