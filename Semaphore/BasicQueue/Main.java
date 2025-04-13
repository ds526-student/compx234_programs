import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        final Main m = new Main();
        final Semaphore semaphore = new Semaphore(3);
        var numThreads = 99;
    
        try (final var executor = Executors.newFixedThreadPool(numThreads + 1)){
            for (int i = 0; i < numThreads; i++) {
                executor.submit(() -> {
                    m.tryAcquire(semaphore);
                });
            }
            executor.submit(() -> {
                while (true) { 
                    Thread.sleep(1000);
                    System.out.println("Current queue length " +
                        semaphore.getQueueLength());
                }
            });
        }
        
    }
    public void tryAcquire(Semaphore semaphore) {
        try {
            semaphore.acquire();
            Thread.sleep(RANDOM.nextInt(1000)); 
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
