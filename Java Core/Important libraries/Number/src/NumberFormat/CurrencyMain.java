package NumberFormat;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyMain {
    public static void main(String[] args) {
        double currency = 101.999f;

        // định dạng tiền tệ của khu vực mặc định của máy ảo JVM
        // khu vực mặc định này là nước Mỹ
        // nên đơn vị của tiền tệ sẽ là $
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String str = currencyFormat.format(currency);
        System.out.println("Số " + currency + " sau khi định dạng = " + str);
        System.out.println("Kiểu đơn vị tiền tệ của " + System.getProperty("user.country") +
                " là " + currencyFormat.getCurrency());

        long vnd = 10000000L;

        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(vnd);
        System.out.println("Số " + vnd + " sau khi định dạng = " + str1);
        System.out.println("Kiểu đơn vị tiền tệ của " + localeVN.getCountry() +
                " là " + currencyVN.getCurrency());
    }
}