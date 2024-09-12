package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteStringsToFiles {
    public static void main(String[] args) {

        try {

            Path utfFile = Files.createTempFile("some", ".txt");
            Files.writeString(utfFile, "this is my string ää öö üü...");
            System.out.println("utFile = "+ utfFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            Path iso88591File = Files.createTempFile("some", ".txt");
            Files.writeString(iso88591File, "this is my string ää öö üü...", StandardCharsets.ISO_8859_1);
            System.out.println("iso88591File = " + iso88591File);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
