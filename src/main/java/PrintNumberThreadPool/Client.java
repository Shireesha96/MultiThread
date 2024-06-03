package PrintNumberThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        ExecutorService ex = Executors.newCachedThreadPool(); // no limit, if available re use else creates new
        //thread for new task

        //instead to limit number of threads being used, only 10 threads will be created
        //10 tasks can be taken by threads, rest have to wait until any of the thread is free
        ExecutorService ex2 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            Printer p = new Printer(i);
            ex.submit(p);
            ex2.submit(p);
        }
    }
}
