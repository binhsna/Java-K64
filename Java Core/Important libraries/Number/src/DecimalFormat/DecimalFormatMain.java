package DecimalFormat;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

public class DecimalFormatMain {
    public static void main(String[] args) {
        double doubleNumber = 1.223d;

        // khai báo 1 DecimalFormat có tên là dcf
        // để định dạng số doubleNumber theo mẫu "#.##"
        // tức là phần thập phân của số doubleNumber sau khi định dạng sẽ có 2 chữ số
        DecimalFormat dcf = new DecimalFormat("#.##");
        System.out.println("Số " + doubleNumber + " sau khi định dạng = " +
                dcf.format(doubleNumber));
        //=>
        double floatNumber = 232323.1523545d;

        // tạo 1 DecimalFormat để định dạng số theo tiêu chuẩn của nước Anh
        Locale locale = new Locale("en", "EN");

        // khai báo 1 DecimalFormat có tên là dcf2
        // để định dạng số floatNumber theo mẫu "####,###.##"
        // tức là phần thập phân của số floatNumber sau khi định dạng sẽ có 2 chữ số
        // và phần ngàn của số sẽ được phân cách bằng dấu phẩy
        // lưu ý: trong pattern chúng ta nhận thấy phần đứng trước dấu thập phân có 7 chữ số
        // trong khi số floatNumber của chúng ta có 6 chữ số ở phần nguyên
        // vì vậy đối với DecimalFormat thì tất cả các chữ số ở phần nguyên
        // là bất kỳ và không phụ thuộc vào số chữ số phần nguyên được khai báo trong pattern
        // nhưng phần thập phân của số phải bằng với phần thập phân của pattern
        String pattern = "###,###.##";
        DecimalFormat dcf2 = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        dcf2.applyPattern(pattern);  // áp dụng mẫu pattern = "###.##" cho dcf
        System.out.println("Số " + floatNumber + " sau khi định dạng = " +
                dcf2.format(floatNumber));
    }
}
