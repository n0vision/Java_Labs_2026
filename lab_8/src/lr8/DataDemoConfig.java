package lr8;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class DataDemoConfig {

    private static final Path DATA_DIR = Paths.get(System.getProperty("user.dir"), "data");

    private DataDemoConfig() {
    }

    public static Path getDataDir() {
        return DATA_DIR;
    }

    public static Path resolve(String first, String... more) {
        return DATA_DIR.resolve(Paths.get(first, more));
    }

    public static boolean isDemoMode() {
        return Boolean.getBoolean("lab8.demo");
    }
}
