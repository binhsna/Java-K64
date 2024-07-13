package FormatDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDate {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        System.out.println("Thời gian hiện tại là " + date);

        // khai báo 1 đối tượng SimpleDateFormat
        // chi tiết về khai báo đối tượng chúng ta sẽ học trong chương "Lập trình hướng đối tượng"
        // đối tượng này sẽ định dạng ngày theo cấu trúc "dd/MM/yyyy"
        // trong đó "dd" là ngày, "MM" là tháng và "yyyy" là năm
        // nếu ngày và tháng nào có 1 chữ số (ví dụ 1, 2, 3,...)
        // thì sẽ được tự động thêm vào số 0 đằng trước
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // hiển thị date theo cấu trúc mà chúng ta đã khai báo (dd/MM/yyyy)
        // sử dụng phương thức format()
        System.out.println("Thời gian hiện tại sau khi định dạng là " + sdf.format(date));

        // định dạng ngày hiện tại theo cấu trúc "d/M/yyyy"
        // trong đó "d" là ngày, "M" là tháng và "yyyy" là năm
        // với kiểu định dạng này thì ngày và tháng nào có 1 chữ số (ví dụ 1, 2, 3,...)
        // thì sẽ không được thêm vào số 0 đằng trước
        SimpleDateFormat sdf1 = new SimpleDateFormat("d/M/yyyy");
        System.out.println("Thời gian hiện tại sau khi định dạng là " + sdf1.format(date));

        // định dạng ngày giờ hiện tại theo cấu trúc "dd/MM/yyyy HH:mm:ss"
        // trong đó "HH" là giờ, "mm" là phút và "ss" là giây
        // "HH" là định dạng 24 giờ, và "hh" là định dạng 12 giờ
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Ngày giờ hiện tại sau khi định dạng là " + sdf2.format(date));

        // hiển thị ngày giờ theo định dạng 12 giờ
        // với định dạng 12 giờ thì chúng ta sẽ thêm vào "aaa"
        // trong đó "aaa" đại diện cho AM/PM
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
        System.out.println("Ngày giờ hiện tại sau khi định dạng là " + sdf3.format(date));
    }
}
