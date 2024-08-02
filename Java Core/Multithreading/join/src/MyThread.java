public class MyThread extends Thread {
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + " đang chạy.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Kết thúc " + Thread.currentThread().getName());
    }
}