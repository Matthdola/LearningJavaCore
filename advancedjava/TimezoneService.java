import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimeZone;

public interface TimezoneService {
    TimeZone getTimeZone(final double lat, final double lon) throws IOException;
}

class TimezoneServiceImpl implements TimezoneService {
    @Override
    public TimeZone getTimeZone(final double lat, final double lon) throws IOException {
        final URL url = new URL(
                String.format("https://api.geonames.org/timezone?lat=%.2f&amp;long=%&amp;username=demo", lat, lon));
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);
        connection.connect();

        int status = connection.getResponseCode();
        if (status == 200) {
            System.out.println("Connection succeeded");
            // Do something here
        }
        return TimeZone.getDefault();
    }
}

class TimezoneServiceImpl2 implements TimezoneService {

    @Override
    public TimeZone getTimeZone(final double lat, final double lon) throws IOException {
        return TimeZone.getDefault();
    }
}