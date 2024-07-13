import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số thứ nhất: ");
        firstNumber = scanner.nextInt();
        System.out.print("Nhập vào số thứ hai: ");
        secondNumber = scanner.nextInt();

        // tìm số lớn nhất giữa 2 số firstNumber và secondNumber
        // sử dụng phương thức Math.max()
        int maxNumber = Math.max(firstNumber, secondNumber);
        System.out.println("Số lớn nhất trong 2 số " + firstNumber + " và " + secondNumber +
                " là " + maxNumber);
        //=>
        System.out.println("Ví dụ tính sin góc 90 độ.");
        int goc = 90;

        // đưa 1 góc về radian
        double radian = Math.PI * goc / 180;
        System.out.println("sin(" + goc + ") = " + Math.sin(radian));
        //=>
        System.out.println("Ví dụ tính cos góc 45 độ.");
        goc = 45;

        // đưa 1 góc về radian
        radian = Math.PI * goc / 180;
        System.out.println("cos(" + goc + ") = " + Math.cos(radian));
        //=>
        System.out.println("Ví dụ tính tan góc 45 độ.");
        goc = 45;

        // đưa 1 góc về radian
        radian = Math.PI * goc / 180;
        System.out.println("tan(" + goc + ") = " + Math.tan(radian));

        // ngoài ra chúng ta có thể tính tan = sin/cos
        double tan = Math.sin(radian) / Math.cos(radian);
        System.out.println("tan(" + goc + ") = " + tan);
    }
}