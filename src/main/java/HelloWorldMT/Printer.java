package HelloWorldMT;

public class Printer implements Runnable{
    @Override
    public void run() {
        System.out.println("Task Thread "+ Thread.currentThread().getName());
        System.out.println("Hello World!");
        doSomething();
    }

    private void doSomething(){
        System.out.println("doSomething");
    }
}
