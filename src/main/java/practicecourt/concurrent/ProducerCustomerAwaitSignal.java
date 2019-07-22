package practicecourt.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ProducerCustomerAwaitSignal {

    private static Lock lock = new ReentrantLock();
    private static Condition chef = lock.newCondition();
    private static Condition client = lock.newCondition();
    private static List<Food> foods = new ArrayList<>();

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 3; i++) {
            executor.submit(new Chef(lock, chef, client, foods));
        }
        for (int i = 0; i < 2; i++) {
            executor.submit(new Client(lock, chef, client, foods));
        }
        executor.shutdown();
    }
}

class Chef implements Runnable {

    private Lock lock;
    private List<Food> foods;
    private Condition chef;
    private Condition client;

    Chef(Lock lock, Condition chef, Condition client, List<Food> foods) {
        this.lock = lock;
        this.chef = chef;
        this.client = client;
        this.foods = foods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (foods.size() == 10) {
                    System.out.println("已有 10 份食物，停止生产");
                    chef.await();
                    System.out.println("继续干活");
                }
                foods.add(new Food());
                System.out.println("生产了 1 份食物");
                client.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Client implements Runnable {

    private Lock lock;
    private List<Food> foods;
    private Condition chef;
    private Condition client;

    Client(Lock lock, Condition chef, Condition client, List<Food> foods) {
        this.lock = lock;
        this.chef = chef;
        this.client = client;
        this.foods = foods;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (foods.size() == 0) {
                    System.out.println("没食物了");
                    client.await();
                }
                foods.remove(0);
                System.out.println("吃了 1 份食物");
                chef.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}


