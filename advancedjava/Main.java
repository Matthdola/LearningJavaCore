import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final Set<DaysOfWeek> enumSetAll = EnumSet.allOf(DaysOfWeek.class);
        final Set<DaysOfWeek> enumSetNone = EnumSet.noneOf(DaysOfWeek.class);
        final Set<DaysOfWeek> enumSetSome = EnumSet.of(DaysOfWeek.SUNDAY, DaysOfWeek.SATURDAY);

        final Map<DaysOfWeek, String> enumMap = new EnumMap<>(DaysOfWeek.class);
        enumMap.put(DaysOfWeek.MONDAY, "Lundi");
        enumMap.put(DaysOfWeek.TUESDAY, "Mardi");
    }
}