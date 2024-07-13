package Calendar;

import java.util.Calendar;

public class ChangeTimeMain {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        // thay đổi ngày hiện tại thành ngày 9
        // tháng hiện tại thành tháng 12
        // năm hiện tại thành năm 2018
        // giờ hiện tại thành 10
        // phút hiện tại thành 59
        // và giây hiện tại thành 59
        // sử dụng phương thức set()
        cal.set(Calendar.DAY_OF_MONTH, 9);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        // hiển thi thời gian hiện tại sau khi thay đổi
        System.out.println(cal.getTime());

        // hoặc chúng ta có thể thay đổi tất cả như sau
        cal.set(2016, Calendar.APRIL, 30, 20, 23, 8);

        System.out.println(cal.getTime());
    }
}