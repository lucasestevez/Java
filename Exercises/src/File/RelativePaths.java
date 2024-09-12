package File;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePaths {
    public static void main(String[] args) {

        Path p = Paths.get("./src/main/java/../resources/some.properties");
        System.out.println("p.isAbsolute() = " + p.isAbsolute());

    }
}
