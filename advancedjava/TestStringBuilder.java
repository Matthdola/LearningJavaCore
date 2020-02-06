import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Date;

public class TestStringBuilder {
    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 10; ++i) {
            sb.append(" ");
            sb.append(i);
        }

        sb.deleteCharAt(0);
        sb.insert(0, "[");
        sb.replace(sb.length() - 3, sb.length(), "]");
        // Using of String formating
        System.out.println(String.format("%04d", 1)); // 0001
        System.out.println(String.format("%.2f", 12.324234d)); // 12.32
        System.out.println(String.format("%tR", new Date())); // 12:22
        System.out.println(String.format("%tF", new Date())); // 2020-02-04
        System.out.println(String.format("%d%%", 12)); // 12%
    }

    public void readFile(final File file) {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            // Some implementation
        } catch (IOException e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (final IOException e) {
                    // do nothing
                }
            }
        }
    }

    public void readFileTWR(File file) {
        try (InputStream in = new FileInputStream(file)) {
            // Some implementation
        } catch (final IOException ex) {
            // Some implementation here
        }
    }

    public void readFileFunc() {
        run(() -> {
            Files.readAllBytes(new File("some.txt").toPath());
        });
    }

    public void readFileFuncWEx() {
        run(() -> {
            try {
                Files.readAllBytes(new File("some.txt").toPath());
            } catch (final IOException ex) {
                throw new RuntimeException("Error reading file", ex);
            }
        });
    }

    public void run(final Runnable runnable) {
        runnable.run();
    }

}