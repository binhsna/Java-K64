package StringTokenizer;

import java.util.StringTokenizer;

/*
StringTokenizer được sử dụng để
tách 1 chuỗi thành các phần tử (token) nhỏ hơn (tương tự như split())
*/
public class Main {
    public static void main(String[] args) {
        // Dạng 1: Tạo 1 StringTokenizer mới
        // với str là chuỗi mà chúng ta cần tách ra thành các token
        // ký tự phân tách mặc định là khoảng trắng, tab, các ký tự xuống dòng
        String str = "StringTokenizer dạng 1";
        StringTokenizer stringTokenizer1 = new StringTokenizer(str);

        // Dạng 2: Tạo 1 StringTokenizer mới
        // với str1 là chuỗi mà chúng ta cần tách ra thành các token
        // và ký tự phân tách là "\n"
        String str1 = "StringTokenizer dạng 2";
        StringTokenizer stringTokenizer2 = new StringTokenizer(str1, "\n");

        // Dạng 3: Tạo 1 StringTokenizer mới
        // với str2 là chuỗi mà chúng ta cần tách ra thành các token
        // ký tự phân cách là "\t"
        // returnDelims có giá trị là true.
        String str2 = "StringTokenizer dạng 3";
        StringTokenizer stringTokenizer3 = new StringTokenizer(str2, "\t", true);
    }
}
