import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class MethodeReference {
    public static void println(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        final Collection<String> strings = Arrays.asList("s1", "s2", "s3");
        strings.stream().forEach(MethodeReference::println);

        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime tomorrow = now.plusHours(24);

        final LocalDateTime midNight = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public <T> Collection<T> find(String s) {
        // Some implementation
        return Collections.emptyList();
    }

    // The use of lambdas expression in Java 8
    public void testLambdas() {
        String[] strings = { "s1", "s2", "s3", "s4", "s5" };
        Arrays.stream(strings).forEach((locale) -> {
            System.out.println(locale);
        });

        Arrays.stream(strings).forEach(MethodeReference::println);
    }
}