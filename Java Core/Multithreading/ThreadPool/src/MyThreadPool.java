import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> hangDoi = new ArrayBlockingQueue<>(100);
        // khi số tiến trình của chúng ta vượt quá maxSize ở đây là 5
        // ví dụ như đối số thứ nhất = 6
        // thì tất cả những tiến trình mới mà chúng ta tạo ra sẽ được đưa vào hangDoi
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 12,
                TimeUnit.SECONDS, hangDoi);

        // dùng vòng lặp for để có thể chạy các Thread
        for (int i = 0; i < 10; i++) {
            // trong phương thức execute() thì đối số truyền vào phải là một Runnable
            // đó là lý do mà lớp RunPool phải implements từ interface Runnable
            threadPoolExecutor.execute(new RunPool(i));
        }
    }
}