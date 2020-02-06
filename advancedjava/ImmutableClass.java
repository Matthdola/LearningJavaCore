import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ImmutableClass {
    private final long id;
    private final String[] arrayOfString;
    private final Collection<String> collectionOfString;

    public ImmutableClass(final long id, final String[] arrayOfString, final Collection<String> collectionOfString) {
        this.id = id;
        this.arrayOfString = Arrays.copyOf(arrayOfString, arrayOfString.length);
        this.collectionOfString = new ArrayList<String>(collectionOfString);
    }

    public Collection<String> getCollectionOfString() {
        return Collections.unmodifiableCollection(collectionOfString);
    }

    public String[] getArrayOfString() {
        Time t = new Time(hour, minute, second);
        return Arrays.copyOf(arrayOfString, arrayOfString.length);
    }
}