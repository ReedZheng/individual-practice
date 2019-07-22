package practicecourt.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ProducerCustomerBlockingQueue {

    private static LinkedBlockingQueue<Food> queue = new LinkedBlockingQueue(10);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 1; i++) {
            executor.submit(new P(queue));
        }
        for (int i = 0; i < 2; i++) {
            executor.submit(new C(queue));
        }
        executor.shutdown();

        ArrayBlockingQueue queue2 = new ArrayBlockingQueue(8);

    }

}

class P implements Runnable {

    private LinkedBlockingQueue<Food> queue;

    P(LinkedBlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(new Food());
                System.out.println("放入一个");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable {

    private LinkedBlockingQueue<Food> queue;

    C(LinkedBlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println("取走一个");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
