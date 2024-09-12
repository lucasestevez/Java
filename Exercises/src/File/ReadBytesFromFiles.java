package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadBytesFromFiles {
    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü");

        String s = new String(Files.readAllBytes(utfFile), StandardCharsets.UTF_8);
        System.out.println("s = "+ s);
    }
}
