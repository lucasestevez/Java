package File;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFiles {
    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");

        try {

            Files.move(utfFile, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()));

        } catch (FileAlreadyExistsException e) {

            e.printStackTrace();
        }

    }
}
