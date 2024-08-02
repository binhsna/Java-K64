
public class TestJoinThread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("Thread 1");
        thread1.start();    // khởi chạy thread 1
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyThread thread2 = new MyThread();
        thread2.setName("Thread 2");
        thread2.start();    // khởi chạy thread2
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyThread thread3 = new MyThread();
        thread3.setName("Thread 3");
        thread3.start();    // khởi chạy thread3
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}