package File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFilesInSameDir {
    public static void main(String[] args) {

        Path tmpDirectory = Paths.get("");

        try (var files = Files.list(tmpDirectory)) {
            files.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var files = Files.newDirectoryStream(tmpDirectory, "*.txt")) {
            files.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
