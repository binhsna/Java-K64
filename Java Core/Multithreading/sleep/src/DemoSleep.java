/*
 * // Tạm dừng Thread với khoảng thời gian dừng tính bằng millisecond
 * Thread.sleep(long millis);
 * // Tạm dừng Thread với khoảng thời gian dừng tính bằng thời gian millis (tính bằng milliseconds) cộng với thời gian nanos (tính bằng nanoseconds và nằm trong khoảng từ 0-999999)
 * Thread.sleep(long millis, int nanos);
 * */
public class DemoSleep extends Thread {
    public void run() {
        super.run();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Đây là Thread thứ " + i);
            System.out.println("Tạm dừng 5000 milliseconds trước khi chuyển sang Thread tiếp theo");
            if (i == 5) {
                System.out.println("Kết thúc!");
            }
            try {
                // tạm dừng 5000 milliseconds trước khi in ra câu tiếp theo
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}