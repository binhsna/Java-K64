package DecimalFormat;

import java.text.DecimalFormat;

public class PercentAndCurrency {
    public static void main(String[] args) {
        // định dạng số ở dạng tiền tệ
        long currency = 25000L;
        String patternCurrency = "$###";    // khi hiển thị sẽ có ký tự "$" đứng đầu
        DecimalFormat dcfCurrency = new DecimalFormat(patternCurrency);
        String strCurrency = dcfCurrency.format(currency);
        System.out.println("Số " + currency + " sau khi định dạng ở dạng tiền tệ = " + strCurrency);

        // định dạng số ở dạng phần trăm
        double percent = 0.082d;

        // định dạng số với 2 chữ số ở phần thập phân
        // còn phần nguyên không phụ thuộc vào phần nguyên được khai báo trong pattern
        String patternPercent = "###.##%";  // khi hiển thị sẽ có ký tự "%" đứng cuối
        DecimalFormat dcfPercent = new DecimalFormat(patternPercent);
        String strPercent = dcfPercent.format(percent);
        System.out.println("Số " + percent + " sau khi định dạng ở dạng phần trăm = " + strPercent);
    }
}
