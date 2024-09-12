package File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFilesRecursively {
    public static void main(String[] args) {

        Path tmpDirectory = Paths.get("");

        try (var files = Files.walk(tmpDirectory)) {
            files.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
