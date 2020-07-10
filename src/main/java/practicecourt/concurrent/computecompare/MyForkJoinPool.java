package practicecourt.concurrent.computecompare;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: zhengfenghong
 * @Date: 2020/6/24 11:34
 */
public class MyForkJoinPool implements Calculate {

    ForkJoinPool pool = ForkJoinPool.commonPool();

    @Override
    public Long sum(long[] nums) {
        return pool.invoke(new MyTask(nums, 0, nums.length - 1));
    }

    private class MyTask extends RecursiveTask<Long> {

        private long[] data;
        private int from;
        private int to;

        MyTask(long[] data, int from, int to) {
            this.data = data;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from < 1000) {
                long result = 0L;
                for (int i = from; i <= to; i++) {
                    result += data[i];
                }
                return result;

            } else {
                int middle = (from + to) / 2;
                MyTask task1 = new MyTask(data, from, middle);
                MyTask task2 = new MyTask(data, middle + 1, to);
                task1.fork();
                task2.fork();
                return task2.join() + task1.join();
            }
        }
    }
}
