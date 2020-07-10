package practicecourt.concurrent.computecompare;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhengfenghong
 * @Date: 2020/6/24 10:51
 */
public class MyExecutor implements Calculate {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(20));

    @Override
    public Long sum(long[] nums) throws ExecutionException, InterruptedException {
        Long result = 0L;
        List<Future<Long>> futures = new ArrayList<>();
        int section = nums.length / 4;
        for (int i = 0, k = 0; i < nums.length - 1; i += section, k++) {
            int from = k * section;
            int to = (k == 3) ? nums.length - 1 : (k + 1) * section - 1;
            Future<Long> submit = executor.submit(new MyJob(nums, from, to));
            futures.add(submit);
        }
        for (Future<Long> future : futures) {
            result += future.get();
        }
        executor.shutdown();
        return result;
    }

    private class MyJob implements Callable<Long> {

        private long[] data;
        private int from;
        private int to;

        MyJob(long[] data, int from, int to) {
            this.data = data;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            Long sum = 0L;
            for (int i = from; i <= to; i++) {
                sum += data[i];
            }
            return sum;
        }
    }
}
