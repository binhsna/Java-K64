package ThiGiuaKy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class checkPrimes {
    public static void main(String[] args) {
        // Input
        int[] A = null;
        do {
            A = Input();
        } while (A == null);
        // Output
        Show(A);
        // In ra số nguyên tố của A[]
        List<Integer> arr = new ArrayList<>();
        for (int a : A) {
            if (KTSoNguyenTo(a)) {
                AddArrNoDup(a, arr);
            }
        }
        System.out.println("Số nguyên tố của mảng A là: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        if (arr.isEmpty()) {
            System.out.println("Mảng A không tồn tại số nguyên tố nào!");
        }

    }

    public static int[] Input() {
        // Khai báo 1 mảng số nguyên gồm n phần tử
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] A = null;
        try {
            System.out.print("Nhập số phần tử của mảng: n = ");
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("--> n là số?");
            return null;
        }
        try {
            A = new int[n];
            // Input A[]
            System.out.println("Nhập mảng A: ");
            for (int i = 0; i < n; i++) {
                System.out.print("A[" + i + "] = ");
                A[i] = sc.nextInt();
            }
        } catch (Exception e) {
            A = null;
            System.out.println("--> A[i] là số?");
        }
        return A;
    }

    public static void Show(int[] A) {
        System.out.println("--> Mảng A: ");
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void AddArrNoDup(int a, List<Integer> arr) {
        if (!arr.contains(a)) {
            arr.add(a);
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
