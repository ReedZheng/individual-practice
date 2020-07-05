package practicecourt.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: reed
 */
public class ReadWriteLockDemo {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock writeLock = lock.writeLock();
    private static Lock readLock = lock.readLock();
    private static int[] arr = new int[10];

    public static void main(String[] args) {
        Thread t1 = new Thread(new WriteTask());
        Thread t2 = new Thread(new ReadTask());
        Thread t3 = new Thread(new ReadTask());

        //        t1.start();
        //        t2.start();
        //        t3.start();

        //        Thread t4 = new Thread(new UPTask());
        //        t4.start();

        new Thread(new DOWNTaskTest()).start();
        Thread t5 = new Thread(new DOWNTask());
        t5.start();

    }

    static class WriteTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                writeLock.lock();
                try {
                    int index = (int) (Math.random() * 10);
                    arr[index] = (int) (Math.random() * 100);
                    System.out.println("+持有写锁, 将 arr[" + index + "] 修改为 " + arr[index] + ", " + Thread.currentThread()
                            .getName());
                } finally {
                    System.out.println("-写锁释放" + ", " + Thread.currentThread()
                            .getName());
                    writeLock.unlock();
                }
            }
        }
    }

    static class ReadTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                readLock.lock();
                try {
                    int index = (int) (Math.random() * 10);
                    System.out.println("+持有读锁，下标 " + index + "，值 " + arr[index] + ", " + Thread.currentThread()
                            .getName());
                } finally {
                    System.out.println("-读锁释放" + ", " + Thread.currentThread()
                            .getName());
                    readLock.unlock();
                }
            }
        }
    }

    static class UPTask implements Runnable {
        @Override
        public void run() {
            readLock.lock();
            writeLock.lock(); // 造成死锁，同个线程先获取读锁再尝试获取写锁，此时整个线程会被阻塞并且没有其他线程释放锁来唤醒这个线程才因此造成的死锁
            try {
                System.out.println("hhhhh");
            } finally {
                readLock.unlock();
                writeLock.unlock();
            }
        }
    }

    static class DOWNTask implements Runnable { // 锁降级
        @Override
        public void run() {
            readLock.lock();
            try {
                System.out.println("arr[0] " + arr[0]);
                if (arr[0] == 0) {
                    readLock.unlock();
                }
                writeLock.lock();
                arr[0] = 100;
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
            System.out.println("arr[0] " + arr[0] + ", 修改完成");
            readLock.unlock();
        }
    }

    static class DOWNTaskTest implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    readLock.lock();
                    System.out.println("arr[0] " + arr[0]);
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

}
