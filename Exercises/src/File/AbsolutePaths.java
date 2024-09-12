package File;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AbsolutePaths {
    public static void main(String[] args) {

        Path p = Paths.get("./src/main/java/../resources/some.properties");
        Path p2 = p.toAbsolutePath();
        System.out.println("p2 = " + p2);
        System.out.println("p2.isAbsolute() = " + p2.isAbsolute());

    }
}
