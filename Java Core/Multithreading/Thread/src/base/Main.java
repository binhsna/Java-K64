package base;

public class Main {
    public static void main(String[] args) {
        //=>C1
        // Tạo ra luồng myThread0 từ lớp MyThread
        MyThread myThread0 = new MyThread();
        myThread0.start();  // kích hoạt luồng

        // Tạo ra luồng myThread1 từ lớp MyThread
        MyThread myThread1 = new MyThread();
        myThread1.start();

        // Tạo ra luồng myThread2 từ lớp MyThread
        MyThread myThread2 = new MyThread();
        myThread2.setName("Luồng 2");   // thay đổi tên luồng thành Luồng 2
        myThread2.start();

        //=>C2
        RunnableThread RunnableThread0 = new RunnableThread();
        Thread thread0 = new Thread(RunnableThread0);
        thread0.start();

        RunnableThread RunnableThread1 = new RunnableThread();
        Thread thread1 = new Thread(RunnableThread1);
        thread1.setName("Luồng 1");
        thread1.start();

        RunnableThread RunnableThread2 = new RunnableThread();
        Thread thread2 = new Thread(RunnableThread2);
        thread2.start();
    }
}