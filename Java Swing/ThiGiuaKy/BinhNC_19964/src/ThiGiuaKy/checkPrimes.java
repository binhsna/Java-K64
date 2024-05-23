package ThiGiuaKy;

import java.util.Scanner;

public class checkPrimes {
    public static void main(String[] args) {
        // Khai báo 1 mảng số nguyên gồm n phần tử
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int A[] = new int[n];
        // Input A[]
        System.out.println("Nhập mảng A: ");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = sc.nextInt();
        }
        // Output
        System.out.println("--> Mảng A: ");
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
        // In ra số nguyên tố của A[]
        int count = 0;
        System.out.println("Số nguyên tố của mảng A là: ");
        for (int a : A) {
            if (KTSoNguyenTo(a) == true) {
                System.out.print(a + " ");
                count++;
            }
        }
        System.out.println();
        if (count <= 0) {
            System.out.println("Mảng A không tồn tại số nguyên tố nào!");
        }

    }


    public static boolean KTSoNguyenTo(int n) {
        boolean kt = true;
        if (n < 2) return kt = false;
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                kt = false;
                break;
            }
            i++;
        }
        return kt;
    }
}
