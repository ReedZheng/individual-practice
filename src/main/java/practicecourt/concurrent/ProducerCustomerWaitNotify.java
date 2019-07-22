package practicecourt.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ProducerCustomerWaitNotify {

    static List<Food> list = new ArrayList<>(10);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.submit(new Producer(list));
        executor.submit(new Producer(list));
        executor.submit(new Customer(list));
        executor.submit(new Customer(list));
        executor.submit(new Customer(list));
        executor.shutdown();
    }
}

class Producer implements Runnable {

    private List<Food> foods;

    Producer(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (foods) {
                while (foods.size() == 10) {
                    System.out.println("已有 10 份食物，停止生产");
                    try {
                        foods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("继续干活");
                }
                foods.add(new Food());
                System.out.println("产出 1 份食物");
                foods.notifyAll();
            }
        }
    }
}

class Customer implements Runnable {

    private List<Food> foods;

    Customer(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (foods) {
                while (foods.size() == 0) {
                    System.out.println("没有食物了");
                    try {
                        foods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                foods.remove(0);
                System.out.println("已吃下 1 份食物");
                foods.notifyAll();
            }
        }
    }
}

class Food {

}