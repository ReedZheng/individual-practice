package practicecourt.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class CyclicBarrierSample {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("计算结果进行合并，合并完成");
        });
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 4; i++) {
            executor.submit(new PartOfCalculation(cyclicBarrier));
        }
        executor.shutdown();
    }
}

class PartOfCalculation implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public PartOfCalculation(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        long sleepTime = (long) (Math.random() * 10000);
        System.out.println(Thread.currentThread().getName() + "正在计算步骤 1");
        try {
            Thread.sleep(sleepTime);
            System.out
                .println(Thread.currentThread().getName() + "步骤 1 计算完成，耗时: " + sleepTime + " ms");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sleepTime = (long) (Math.random() * 10000);
        System.out.println(Thread.currentThread().getName() + "正在计算步骤 2");
        try {
            Thread.sleep(sleepTime);
            System.out
                .println(Thread.currentThread().getName() + "步骤 2 计算完成，耗时: " + sleepTime + " ms");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}