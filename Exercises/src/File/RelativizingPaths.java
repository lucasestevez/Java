package File;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizingPaths {
    public static void main(String[] args) {

        Path p = Paths.get("./src/main/java/../resources/some.properties");
        Path p3 = p.normalize().toAbsolutePath();
        Path relativizedPath = Paths.get("C:\\dev\\java-file-article\\").relativize(p3);
        System.out.println("relativizedPath = " + relativizedPath);

    }
}
