package File;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class JavaWatchService {
    public static void main(String[] args) throws IOException {

        WatchService watcher = FileSystems.getDefault().newWatchService();

        Path dir = Path.of("c:\\someDir\\");

        dir.register(watcher,
                ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY);

        for (;;) {

            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }

                WatchEvent<Path> ev = (WatchEvent<Path>)event;
                Path filename = ev.context();

                Path changedFile = dir.resolve(filename);

                // do something with the file
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }

    }
}
