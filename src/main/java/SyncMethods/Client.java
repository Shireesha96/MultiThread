package SyncMethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Adder a = new Adder(c);
        Subtractor s = new Subtractor(c);

        Thread t = new Thread(a);
        Thread t2 = new Thread(s);

        t.start();
        t2.start();

        t.join();
        t2.join();

        System.out.println(c.getValue());
    }
}
