import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

public class Server {

    private final Semaphore semaphore;
    private final LongAdder loginAttempts;
    private static final int NUM_USERS = 100;

    public Server() {
        semaphore = new Semaphore(NUM_USERS);
        loginAttempts = new LongAdder();
        new Thread(this::printStatus).start();
    }

    private void printStatus() {
        while(true) {
            try {
                Thread.sleep(1000);
                int currentUsers = NUM_USERS - semaphore.availablePermits();
                if (currentUsers == 0){
                    break;
                }
                var result = "Current users: " + currentUsers + ", Login attempts: " + loginAttempts.sum();
                System.out.println(result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Server shutting down... \n" +
                " Login attempts: " + loginAttempts.longValue());
    }

    public boolean tryLogin() {
        loginAttempts.increment();
        return semaphore.tryAcquire();
    }

    public void logout() {
        semaphore.release();
    }
}
