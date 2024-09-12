package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OptionsWhenWritingFiles {
    public static void main(String[] args) throws IOException {

        Path anotherUtf8File = Files.createTempFile("some", ".txt");
        Files.writeString(anotherUtf8File, "this is my string ää öö üü", StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("anotherUtf8File = " + anotherUtf8File);

        Path oneMoreUtf8File = Files.createTempFile("some", ".txt");
        Files.write(oneMoreUtf8File, "this is my string ää öö üü".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("oneMoreUtf8File = " + oneMoreUtf8File);
    }
}
