package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(new RunPool(i));    // chay ThreadPool, đối số là 1 Runnable
        }
        try {
            // thời gian sống của mỗi Thread là 1 ngày (nếu nó chưa thực thi xong)
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();    // tắt ThreadPool
    }
}
