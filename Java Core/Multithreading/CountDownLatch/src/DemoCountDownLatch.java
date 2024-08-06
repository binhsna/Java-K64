import java.util.concurrent.CountDownLatch;

public class DemoCountDownLatch {
    public CountDownLatch count = new CountDownLatch(2000);

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count.countDown();  // giảm giá trị của biến count
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count.countDown();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            count.await();
        } catch (InterruptedException ignored) {

        }
        System.out.println("Count = " + count.getCount());
    }

    public static void main(String[] args) {
        DemoCountDownLatch demo = new DemoCountDownLatch();
        demo.doWork();
    }
}