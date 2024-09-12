package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadStringsFromFiles {
    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü");

        String s = Files.readString(utfFile);
        System.out.println("s = "+ s);

        s = Files.readString(utfFile, StandardCharsets.ISO_8859_1);
        System.out.println("s = "+ s);

    }
}
