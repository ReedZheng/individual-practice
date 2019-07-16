package practicecourt.concurrent;

/**
 * 死锁示例
 */
public class DeadLockSample {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(new Worker(o1, o2));
        Thread t2 = new Thread(new Worker(o2, o1));

        t1.start();
        t2.start();
    }
}

class Worker implements Runnable {

    private final Object o1;
    private final Object o2;

    Worker(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run() {
        synchronized (o1) {
            System.out.println("get " + o1.toString() + " lock");
            synchronized (o2) {
                System.out.println("get " + o2.toString() + " lock");
            }
        }
    }
}
