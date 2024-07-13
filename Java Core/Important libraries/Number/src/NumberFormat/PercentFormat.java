package NumberFormat;

import java.text.NumberFormat;

public class PercentFormat {
    public static void main(String[] args) {
        double percentageDoubleNumber = 0.758d;
        // định dạng số percentageDoubleNumber ở dạng phần trăm
        // theo khu vực mặc định của máy ảo JVM
        // khu vực mặc định này là nước Mỹ
        // lưu ý là phần trăm của số sẽ được làm tròn
        NumberFormat numEN = NumberFormat.getPercentInstance();
        String percentageEN = numEN.format(percentageDoubleNumber);
        System.out.println("Số " + percentageDoubleNumber + " ở dạng phần trăm = " + percentageEN);
    }
}
