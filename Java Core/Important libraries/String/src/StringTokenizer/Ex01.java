package StringTokenizer;

import java.util.StringTokenizer;

public class Ex01 {
    public static void main(String[] args) {
        String str = "Học, học nữa, học mãi!";

        // ký tự phân tách mặc định ở đây là khoảng trắng
        StringTokenizer stringTokenizer = new StringTokenizer(str);

        System.out.println("Kết quả sau khi phân tách theo khoảng trắng: ");
        // kiểm tra xem có còn token kế tiếp trong chuỗi hay không
        // sử dụng phương thức hasMoreTokens()
        while (stringTokenizer.hasMoreTokens()) {
            // nextToken(): lấy token hiện tại ra và di chuyển tới token kế tiếp
            System.out.println(stringTokenizer.nextToken());
        }

        // phân tách stringTokenizer1 vừa theo dấu phẩy và vừa theo khoảng trắng
        // StringTokenizer stringTokenizer1 = new StringTokenizer(str, ", ", true);
        StringTokenizer stringTokenizer1 = new StringTokenizer(str, ", ");

        System.out.println("\nKết quả sau khi phân tách vừa theo dấu phẩy và vừa theo khoảng trắng: ");
        // kiểm tra xem có còn token kế tiếp trong chuỗi hay không
        // sử dụng phương thức hasMoreElements()
        while (stringTokenizer1.hasMoreElements()) {
            System.out.println(stringTokenizer1.nextElement());
        }
    }
}
