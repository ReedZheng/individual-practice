package practicecourt.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池示例
 */
public class ThreadExecutorSample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(5));

        Command command = new Command();
        Future<Integer> f1 = executor.submit(command);
        Future<Integer> f2 = executor.submit(command);

        try {
            f1.get();
            f2.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Experiment.publicVal);
        }

        executor.shutdown();
    }
}

class Experiment {

    static AtomicInteger publicVal = new AtomicInteger(0);
}

class Command implements Callable<Integer> {

    public Integer call() throws Exception {
        for (int i = 0; i < 19; i++) {
            Experiment.publicVal.addAndGet(1);
        }
        return null;
    }
}
