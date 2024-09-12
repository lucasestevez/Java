package File;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFilesIfTheyAreEmpty {
    public static void main(String[] args) {

        Path tmpDir = Paths.get("");

        try {
            Files.delete(tmpDir);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
