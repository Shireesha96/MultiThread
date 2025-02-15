package AdderSubtracterMutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lock;

    public Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        // critical section

        for(int i = 0; i < 10000; i++){
            lock.lock();
            count.value +=1;
            lock.unlock();;
        }
    }
}
