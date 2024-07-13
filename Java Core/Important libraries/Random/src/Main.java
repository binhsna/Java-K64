import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();   // khai báo 1 đối tượng Random
        int number = rd.nextInt();  // trả về 1 số nguyên bất kỳ
        System.out.println("Số vừa được sinh ra (bất kỳ) là " + number);

        // Trả về 1 số nguyên nằm trong phạm vi [0...3]
        int number1 = rd.nextInt(4);
        System.out.println("Số vừa được sinh ra [0, 3] là " + number1);

        // trả về 1 số nguyên nằm trong phạm vi [-4...-1]
        // đối với rd.nextInt(4) thì số lớn nhất là 3 và số nhỏ nhất là 0
        // ta có 3 - 4 = -1 và 0 - 4 = -4
        // nên các số được sinh ra sẽ nằm trong đoạn [-4...-1]
        int number2 = -4 + rd.nextInt(4);
        System.out.println("Số vừa được sinh ra [-4, -1] là " + number2);
        //=>
        float floatNumber = rd.nextFloat(); // trả về 1 số bất kỳ có kiểu là float
        System.out.println("Số vừa được sinh ra (float) là " + floatNumber);
        // trả về 1 số bất kỳ có kiểu là double
        double doubleNumber = rd.nextDouble();
        System.out.println("Số vừa được sinh ra (double) là " + doubleNumber);
        // trả về 1 số bất kỳ có kiểu long
        long longNumber = rd.nextLong();
        System.out.println("Số vừa được sinh ra (long) là " + longNumber);
        // trả về 1 biến bool có giá trị là true hoặc false.
        boolean bool = rd.nextBoolean();
        System.out.println("Giá trị của biến bool là " + bool);
    }
}