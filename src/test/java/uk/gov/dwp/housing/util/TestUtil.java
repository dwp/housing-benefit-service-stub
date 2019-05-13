package uk.gov.dwp.housing.util;

import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;

public class TestUtil {

    /**
     * Suppress default constructor for noninstantiability
     */
    private TestUtil() {
        throw new AssertionError();
    }

    public static String getResourceAsString(final String resource) throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile(resource).toPath()));
    }
}
