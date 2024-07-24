package base;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            // Thread.currentThread().getName(): cho chúng ta biết tên luồng đang chạy
            // và tên luồng này có thể thay đổi được.
            System.out.println(Thread.currentThread().getName());
        }
    }

}