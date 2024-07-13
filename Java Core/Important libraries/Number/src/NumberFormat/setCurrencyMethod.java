package NumberFormat;

import java.util.Currency;
import java.text.NumberFormat;
import java.util.Locale;

public class setCurrencyMethod {
    public static void main(String[] args) {
        double doubleNumber = 6.32d;

        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của của Đức
        Locale locale = new Locale("de", "DE");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String str1 = numberFormat.format(doubleNumber);
        System.out.println("Số " + doubleNumber + " sau khi định dạng = " + str1);

        // thay đổi từ định dạng tiền tệ theo tiêu chuẩn của Đức
        // sang định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // sử dụng phương thức setCurrency()
        // Currency.getInstance() sẽ trả về tiền tệ cho 1 quốc gia nào đó (ở đây là Việt Nam)
        Locale localeVN = new Locale("vi", "VN");
        numberFormat.setCurrency(Currency.getInstance(localeVN));
        String str2 = numberFormat.format(doubleNumber);
        System.out.println("Số " + doubleNumber + " sau khi định dạng = " + str2);
    }
}
