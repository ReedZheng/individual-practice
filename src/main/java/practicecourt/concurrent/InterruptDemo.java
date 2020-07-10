package practicecourt.concurrent;

public class InterruptDemo {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 返回当前中断状态并清空中断标识位
                System.out.println(Thread.interrupted());
            }
        });
        thread.start();
        Thread.sleep(1000);
        // 中断线程
        thread.interrupt();
    }
}
