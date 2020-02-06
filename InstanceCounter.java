public class InstanceCounter {
    private static int instanceCount = 0;

    protected static int instanceCount() {
        return instanceCount;
    }

    private static void incrementCount(){
        ++instanceCount;
    }

    InstanceCounter() {
        InstanceCounter.incrementCount();
    }
}