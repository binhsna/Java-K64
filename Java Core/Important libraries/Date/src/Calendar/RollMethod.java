package Calendar;

import java.util.Calendar;

public class RollMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("Thời gian hiện tại là " + cal.getTime());

        // thay đổi tháng thành 12
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        System.out.println("Thời gian hiện tại sau khi thay đổi là " + cal.getTime());

        // tăng tháng sử dụng phương thức roll()
        // lúc này tháng sẽ là tháng 1 và năm vẫn giữ nguyên
        cal.roll(Calendar.MONTH, 1);
        System.out.println("Thời gian hiện tại sau khi thay đổi là " + cal.getTime());
    }
}