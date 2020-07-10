package practicecourt.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: reed
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        // demo1
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> System.out.println(s1 + " " + s2));

        // demo2
        CompletableFuture.supplyAsync(() -> {
            int i = (int) (Math.random() * 10);
            int time = i * 1000;
            System.out.println("方案1 预计耗时" + time + " ms");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aaa";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            int i = (int) (Math.random() * 10);
            int time = i * 1000;
            System.out.println("方案2 预计耗时" + time + " ms");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "bbb";
        }), a -> a).whenComplete((result, exception) -> {
            if (null == exception) {
                System.out.println("result from previous task: " + result);
            }
        });

        System.out.println(11);

        while (true) {
        }

    }
}
