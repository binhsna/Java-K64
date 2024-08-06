package ExecutorService;

public class RunPool implements Runnable {
    int id;

    @Override
    public void run() {
        System.out.println("Đang xử lý tiến trình " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Đã xử lý tiến trình " + id);
    }

    public RunPool(int id) {
        this.id = id;
    }
}