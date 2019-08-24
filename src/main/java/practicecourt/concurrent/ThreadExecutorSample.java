package practicecourt.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例
 */
public class ThreadExecutorSample {
    public static void main(String[] args) {

        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200),
                new ThreadFactoryBuilder().setNameFormat("Thread-Executor-Sample-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        Command command = new Command();
        for (int i = 0; i < 200; i++) {
            executor.submit(command);
        }

        executor.shutdown();
    }
}

class Command implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " hello world!");
        return 1;
    }
}
