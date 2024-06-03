package AddSubSync;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;


    public Adder(Count count){
        this.count = count;
    }

    @Override
    public void run() {
        // critical section

        synchronized (count) {
            for (int i = 0; i < 10000; i++) {
                count.value += 1;
            }
        }
    }
}
