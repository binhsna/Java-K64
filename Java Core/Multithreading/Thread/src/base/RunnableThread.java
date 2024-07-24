package base;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // Thread.currentThread().getId(): lấy id của luồng đang chạy
            // nó dùng để phân biệt với các luồng khác cùng tiến trình hoặc cùng tập luồng.
            // Đây là thông số mà máy ảo java tự tạo ra khi ta tạo luồng
            // nên ta không thể sửa đổi cũng như áp đặt thông số này khi tạo luồng.
            System.out.println(Thread.currentThread().getId() + "\t" +
                    Thread.currentThread().getName());
        }
    }

}