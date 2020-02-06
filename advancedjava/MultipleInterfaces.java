public class MultipleInterfaces implements Runnable, AutoCloseable {
    @Override
    public void run() {
        // Some implementaion here
    }

    @Override
    public void close() throws Exception {
        // Some implementation here
    }
}

interface A {
    default void performAction() {

    }
}

interface B extends A {
    @Override
    default void perfomAction() {

    }
}

interface C extends A {
    @Override
    default void performAction() {

    }
}

// E is not compilable unless it overrides performAction() as well
interface E extends B, C {

}