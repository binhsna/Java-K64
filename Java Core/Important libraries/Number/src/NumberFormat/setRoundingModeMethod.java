package NumberFormat;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class setRoundingModeMethod {
    public static void main(String[] args) {
        NumberFormat numf = NumberFormat.getNumberInstance();
        numf.setMaximumFractionDigits(2);   // làm tròn đến 2 chữ số phần thập phân

        // RoundingMode.UP: làm tròn lên
        numf.setRoundingMode(RoundingMode.UP);
        System.out.println("Chế độ làm tròn: " + numf.getRoundingMode());
        System.out.println("523.454 sau khi làm tròn = " + numf.format(523.454));
        System.out.println("733.455 sau khi làm tròn = " + numf.format(733.455));
        System.out.println("823.456 sau khi làm tròn = " + numf.format(823.456));

        // RoundingMode.DOWN: làm tròn xuống
        numf.setRoundingMode(RoundingMode.DOWN);
        System.out.println("\nChế độ làm tròn: " + numf.getRoundingMode());
        System.out.println("523.454 sau khi làm tròn = " + numf.format(523.454));
        System.out.println("733.455 sau khi làm tròn = " + numf.format(733.455));
        System.out.println("823.456 sau khi làm tròn = " + numf.format(823.455));
    }
}
