import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class JavaConcurentProgramming {
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Some Implementation
            }
        }).start();

        // Same as above using Java 8 lambda functions
        new Thread(() -> {
            // Some implementation
        }).start();

        // Create a thread pool with a fixe number of thread
        ExecutorService executor = Executors.newFixedThreadPool(10); // Not recommended to use executors for
                                                                     // long-running tasks

        // Fire-and-forget semantic when the execution is no very important
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Some implementation
            }
        });

        // The same implementation with Java 8
        executor.execute(() -> {
            // Some implementation
        });

        // Whe the execution is important, Java provide Future<T>
        Future<Long> result = executor.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // Some implementation
                return 3L;
            }
        });
        // Wait to get the result of the asynchronous program
        Long value = result.get(1, TimeUnit.SECONDS);

        // Use of parallelStream()
        final Collection<String> strings = new ArrayList<>();
        strings.add("Matthias");
        strings.add("DOLA");
        strings.add("Parisien");
        strings.add("Koami");
        strings.add("Software engener");
        strings.add("Work AT France");
        final int sumOfLength = strings.parallelStream().filter(str -> !str.isEmpty()).mapToInt(str -> str.length())
                .sum();
        System.out.println("The sum of elements length is " + sumOfLength);
    }

    public void performAction() {
        lock.lock();
        try {
            // Some implementation here
        } catch (Exception e) {
            lock.unlock();
        }
    }

    public void perfomActionWithTimeout() throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                // Some implementation here
            } finally {
                lock.unlock();
            }
        }
    }

    // Example of Synchronized instance method
    public synchronized void performActionSynch() {
        // Some implementation
    }

    // Example of Synchronized static method
    public static synchronized void perfomClassAction() {
        // Perfom some other action
    }

    // Example of Synchronized block
    public void performActionBlock() {
        synchronized (this) {
            // Some critical action
        }
    }
}