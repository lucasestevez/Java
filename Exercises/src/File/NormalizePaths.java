package File;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizePaths {
    public static void main(String[] args) {

        Path p = Paths.get("./src/main/java/../resources/some.properties");
        Path p3 = p.normalize().toAbsolutePath();
        System.out.println("p3 = " + p3);
        System.out.println("p3.isAbsolute() = " + p3.isAbsolute());

    }
}
