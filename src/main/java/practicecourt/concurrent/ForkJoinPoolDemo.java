package practicecourt.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: reed
 */
public class ForkJoinPoolDemo {

    // 任务阈值
    private static int THRESLOD = 10;

    public static void main(String[] args) throws Exception {
        // 创建他的线程池
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        // 在线程池中进行计算
        Future<Long> ft = forkJoinPool.submit(new MC(1,
            100));

        System.out.println("计算的结果是：" + ft.get());
    }

    /**
     * 求1到100万之间的和，因为需要返回结果，所以需要继承recursiverTask
     */
    static class MC extends RecursiveTask<Long> {

        Long sum = Long.valueOf(0);

        private int begin, end;

        public MC(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        // 表示这个任务完成后，返回的一个值
        @Override
        protected Long compute() {

            // 如果任务量小于阈值，就直接计算
            if ((end - begin) <= THRESLOD) {
                for (int i = begin; i < end; i++) {
                    sum += i;
                }
            } else {
                // 如果大于1000， 就把他拆分成两个子任务进行fork
                int mid = (end + begin) / 2;
                // 一部分小线程
                MC left = new MC(begin,
                    mid);
                // 开启这小部分线程
                left.fork();

                MC right = new MC(mid,
                    end);
                right.fork();
                // 让right任务完整完成
                Long lr = right.join();
                // 让right任务完整完成
                Long li = left.join();
                sum = li + lr;
            }
            return sum;
        }
    }

}
