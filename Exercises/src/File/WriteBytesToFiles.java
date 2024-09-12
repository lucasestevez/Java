package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteBytesToFiles {
    public static void main(String[] args) {

        try {

            Path anotherIso88591File = Files.createTempFile("some", ".txt");
            Files.write(anotherIso88591File, "this is my string ää öö üü...".getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("anotherIso88591File = " + anotherIso88591File);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
