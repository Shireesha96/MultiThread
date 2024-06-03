package PrintNumbers;


public class Client {

    public static void main(String[] args) {

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            Printer p = new Printer(i);
            Thread t = new Thread(p);
            t.start();
        }

        //order not guaranteed

    }

}
