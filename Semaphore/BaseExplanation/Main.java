package BaseExplanation;

import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        Semaphore semaphore = new Semaphore(3); //The constructor requires an int "permits", this tells us how many threads can access the semaphore
        semaphore.acquire(); //takes a permit for use, constructor can be used to change number taken for use
        semaphore.acquire();
        semaphore.release(); //releases a permit, constructor can be used to change number of permits released

        System.out.println(semaphore.availablePermits()); //outputs the number of available permits
    }
}