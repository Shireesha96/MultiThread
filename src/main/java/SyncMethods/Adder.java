package SyncMethods;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }

    @Override
    public void run() {
        // critical section

        for(int i = 0; i < 10000; i++){
            count.increment(i);
        }
    }
}
