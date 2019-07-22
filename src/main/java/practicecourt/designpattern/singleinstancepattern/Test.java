package practicecourt.designpattern.singleinstancepattern;

import practicecourt.designpattern.singleinstancepattern.doublechecklock.DCLWay;
import practicecourt.designpattern.singleinstancepattern.staticinnerclass.StaticInnerWay;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * http://www.importnew.com/18872.html https://blog.csdn.net/mnb65482/article/details/80458571
 * https://blog.csdn.net/chenchaofuck1/article/details/51702129 https://blog.csdn.net/jason0539/article/details/23297037
 */
public class Test {

    public static void main(String[] args) {
        StaticInnerWay instance1 = StaticInnerWay.getInstance();
        System.out.println(instance1);

        StaticInnerWay instance2 = StaticInnerWay.getInstance();
        System.out.println(instance2);

        System.out.println(instance1 == instance2);

        System.out.println(DCLWay.getInstance());

        System.out.println(Single.getInstance());

        System.out.println("---------------------");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println(Single.getInstance());
            });
        }
        executor.shutdown();
    }
}
