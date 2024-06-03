package AdderSubtracterMutex;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {

        // critical section where problem happens
        // hence we add locks
        // we can add for the line of code
        // or we can add for the for loop

        lock.lock();
        for (int i = 0; i < 10000; i++) {
            count.value -= 1;
        }
        lock.unlock();
    }
}
