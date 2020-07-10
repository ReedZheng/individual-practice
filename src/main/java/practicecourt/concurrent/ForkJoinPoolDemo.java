package practicecourt.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: reed
 */
public class ForkJoinPoolDemo {

    private static int THRESLOD = 10;//任务阈值

    public static void main(String[] args) throws Exception {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();//创建他的线程池

        Future<Long> ft = forkJoinPool.submit(new MC(1,
            100));//在线程池中进行计算
//
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

        //表示这个任务完成后，返回的一个值
        @Override
        protected Long compute() {

            //如果任务量小于阈值，就直接计算
            if ((end - begin) <= THRESLOD) {
                for (int i = begin; i < end; i++) {
                    sum += i;
                }
            } else {//如果大于1000， 就把他拆分成两个子任务进行fork

                int mid = (end + begin) / 2;

                MC left = new MC(begin,
                    mid);//一部分小线程
                left.fork();//开启这小部分线程

                MC right = new MC(mid,
                    end);
                right.fork();

                Long lr = right.join();//让right任务完整完成
                Long li = left.join();//让left任务完整完成
                sum = li + lr;
            }
            return sum;
        }
    }
}
