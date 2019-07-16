package practicecourt.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class CountDownLatchSample {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(new Suborker(countDownLatch));
        }
        try {
            countDownLatch.await();
            System.out.println("子任务全部执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }
}

class Suborker implements Runnable {

    private CountDownLatch countDownLatch;

    public Suborker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        long sleepTime = (long) (Math.random() * 10000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子任务启动，耗时: " + sleepTime + " ms");
        countDownLatch.countDown();
    }
}
