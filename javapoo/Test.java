import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test extends Object {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.toString());
        Date date = new Date();
        System.out.println(date.toString());

        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println(calendar.toString());

        calendar = new GregorianCalendar(2019, Calendar.DECEMBER, 28);
        System.out.println(calendar.toString());
    }

}