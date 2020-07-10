package practicecourt.concurrent.computecompare;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @Author: zhengfenghong
 * @Date: 2020/6/24 14:48
 */
public class Test {

    public static void main(String[] args) throws Exception {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculate calculator = new ForLoop();
        long result = calculator.sum(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");
        System.out.println("结果为：" + result);

        Instant start2 = Instant.now();
        Calculate calculator2 = new MyExecutor();
        long result2 = calculator2.sum(numbers);
        Instant end2 = Instant.now();
        System.out.println("耗时：" + Duration.between(start2, end2).toMillis() + "ms");
        System.out.println("结果为：" + result2);

        Instant start3 = Instant.now();
        Calculate calculator3 = new MyForkJoinPool();
        long result3 = calculator3.sum(numbers);
        Instant end3 = Instant.now();
        System.out.println("耗时：" + Duration.between(start3, end3).toMillis() + "ms");
        System.out.println("结果为：" + result3);

    }

}
