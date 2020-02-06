import java.io.File;

public class TestException {
    public static void main(String[] args) {

        try {
            File f = new File("test.txt");
            f.open();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        } finally {
            // f.close();
        }
    }
}