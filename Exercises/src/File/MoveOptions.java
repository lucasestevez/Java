package File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveOptions {
    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");

        Path utfFile2 = Files.createTempFile("some", ".txt");
        Files.move(utfFile2, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

        Path utfFile3 = Files.createTempFile("some", ".txt");
        Files.move(utfFile3, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);
    }
}
