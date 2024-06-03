package HelloWorldMT;

public class Client {

    // using multi threads
    //create class for task - printer which implements runnable
    //create object for the same
    //create thread and pass object

    public static void main(String[] args){
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        Printer p = new Printer();
        Thread t = new Thread(p);
        t.start();

        System.out.println("Bye");

    }
}
