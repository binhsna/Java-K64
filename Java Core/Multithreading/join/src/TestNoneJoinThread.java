public class TestNoneJoinThread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("Thread 1");
        MyThread thread2 = new MyThread();
        thread2.setName("Thread 2");
        MyThread thread3 = new MyThread();
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
