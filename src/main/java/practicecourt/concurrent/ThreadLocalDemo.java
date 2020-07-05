package practicecourt.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: reed
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> local = new ThreadLocal();

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                20,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20));
        for (int i = 0; i < 10; i++) {
            executor.submit(new Q());
        }
        executor.shutdown();
    }

    static class Q implements Callable {
        @Override
        public Object call() throws Exception {
            local.set((int) (Math.random() * 100));
            System.out.println(Thread.currentThread()
                    .getName() + " : local " + local.get());
            return null;
        }
    }
}
