package Calendar;

import java.util.Calendar;
import java.util.Date;

public class GetTimeMain {
    public static void main(String[] args) {
        // Tạo đối tượng Calendar mô tả thời điểm hiện tại
        // với Locale (khu vực) và TimeZone (múi giờ)
        // của máy tính đang chạy.
        Calendar cal = Calendar.getInstance();

        // import java.util.Date; để sử dụng Date
        // hiển thị ngày tháng năm giờ phút giây hiện tại của hệ thống
        // sử dụng phương thức getTime()
        // phương thức này sẽ trả về 1 đối tượng Date
        // lưu trữ thông tin ngày tháng năm giờ phút giây hiện tại của hệ thống
        Date date = cal.getTime();
        // hiển thị thời gian hiện tại
        System.out.println("Thời gian hiện tại của hệ thống là: " + date);
    }
}