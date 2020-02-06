import java.util.Arrays;

public class PairTest {

    static int wheels = 5;
    private boolean numLock = true;
    static boolean capLock = false;
    private static boolean heatWave = true;

    public static void main(String[] args) {
        String[] words = { "Mary", "had", "a", "little", "lamb" };
        // Pair<String> mm = ArrayAlg.minmax(words);
        // System.out.println("min = " + mm.getFirst());
        // System.out.println("max = " + mm.getSecond());
        String tree = "pine";
        int count = 0;
        if (tree.equals("pine")) {
            int height = 55;
            count = count + 1;
        }
        // System.out.println(numLock+" "+capLock);
        // System.out.print(height + count);
        System.out.println("minimum = " + ArrayAlg.min(words));
        new PairTest().printColor("red");
        int t = new PairTest().wheels;
        System.out.println(t);
        boolean heatWave = false;
        System.out.println(heatWave);
    }

    private void printColor(String color) {
        color = "purple";
        boolean f = false, numLock = false;
        System.out.println(f + " " + capLock);
        System.out.println(color);
    }

    static class ArrayAlg {
        public static <T extends Comparable> Pair<T> minmax(T[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            T min = arr[0];
            T max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                // int compare = min.compareTo(arr[i]);
                if (min.compareTo(arr[i]) > 0)
                    min = arr[i];
                if (max.compareTo(arr[i]) < 0)
                    max = arr[i];
            }
            return new Pair<>(min, max);
        }

        public static <T extends Comparable> T min(T[] a) {
            if (a == null || a.length == 0)
                return null;
            T min = a[0];
            for (int i = 0; i < a.length; i++) {
                T item = a[i];
                int result = min.compareTo(item);
                System.out.println(String.format("minimun %s, item %s, result of compare %s", min, item, result));
                if (min.compareTo(a[i]) > 0)
                    min = a[i];
            }
            return min;
        }
    }
}