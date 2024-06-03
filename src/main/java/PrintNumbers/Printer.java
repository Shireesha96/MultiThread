package PrintNumbers;

public class Printer implements Runnable{
    private int number;

    public Printer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + number);
        //print(number);
    }

    private void print(int x){
        System.out.println(x);
    }
}
