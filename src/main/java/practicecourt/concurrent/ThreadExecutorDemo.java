package practicecourt.concurrent;

import java.util.Stack;
import java.util.concurrent.Callable;

/**
 * 线程池示例
 */
public class ThreadExecutorDemo {

    public static void main(String[] args) {

        new ThreadExecutorDemo().test2();

        // ThreadPoolExecutor executor =
        //     new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200),
        //         new ThreadFactoryBuilder().setNameFormat("Thread-Executor-Sample-%d").build(),
        //         new ThreadPoolExecutor.AbortPolicy());
        //
        // Command command = new Command();
        // for (int i = 0; i < 200; i++) {
        //     executor.submit(command);
        // }
        //
        // executor.shutdown();
    }

    public void test() {
        try {
            int i = 0;
            for (; ; ) {
                i = 5 / 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("asdf");
        }
    }

    boolean acquireQueued(Integer node, int arg) {
        boolean failed = true;
        try {
            int i = 0;
            // boolean interrupted = false;
            for (; ; ) {
                if (1 == 1) {
                    return true;
                }
                System.out.println("!");
                i = 5 / 0;
            }

        } finally {
            if (failed) {
                // cancelAcquire(node);
                System.out.println("/?!");
            }
        }
    }

    // 负数会出错
    public void test2() {
        int num = 121;
        Stack<Integer> stack = new Stack<>();

        while (num != 0) {
            stack.push(num & 1);
            num >>= 1;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

class Command implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " hello world!");
        return 1;
    }
}
