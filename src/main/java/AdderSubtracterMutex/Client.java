package AdderSubtracterMutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Count c = new Count();
        Adder a = new Adder(c, lock);
        Subtractor s = new Subtractor(c, lock);

        Thread t = new Thread(a);
        Thread t2 = new Thread(s);

        t.start();
        t2.start();

        t.join();
        t2.join();

        System.out.println(c.value);
    }
}
