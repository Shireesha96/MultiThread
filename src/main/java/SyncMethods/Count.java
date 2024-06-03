package SyncMethods;

public class Count {

    private int value = 0;

    // if thread using synchronized method
    // it locks all the sync methods for the same object
    public synchronized void increment(int i) {
        this.value += i;
    }

    public int getValue() {
        return this.value;
    }
}

