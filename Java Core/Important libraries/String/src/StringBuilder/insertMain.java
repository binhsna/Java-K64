package StringBuilder;

/*
Phương thức insert() là phương thức dùng để chèn 1 ký tự/số/chuỗi
vào 1 vị trí bất kỳ trong StringBuilder
*/
public class insertMain {
    public static void main(String[] args) {
        // chèn 1 chuỗi biểu diễn giá trị boolean vào vị trí số 3 trong stringBuilder1
        StringBuilder stringBuilder1 = new StringBuilder("StringBuilder1");
        boolean bool = false;
        stringBuilder1.insert(3, bool);
        System.out.println("Kết quả chèn 1 chuỗi biểu diễn giá trị boolean: " + stringBuilder1);

        // chèn 1 chuỗi biểu diễn giá trị char vào vị trí số 2 trong stringBuilder2
        StringBuilder stringBuilder2 = new StringBuilder("StringBuilder2");
        char ch = 'v';
        stringBuilder2.insert(2, ch);
        System.out.println("Kết quả chèn 1 chuỗi biểu diễn giá trị char: " + stringBuilder2);

        // chèn 1 chuỗi biểu diễn giá trị của 1 mảng các ký tự vào vị trí số 6 trong stringBuilder3
        StringBuilder stringBuilder3 = new StringBuilder("StringBuilder3");
        char[] ch1 = {'a', 'e', 'f'};
        stringBuilder3.insert(6, ch1);
        System.out.println("Kết quả chèn 1 chuỗi biểu diễn giá trị của 1 mảng các ký tự: " +
                stringBuilder3);


        // chèn 1 chuỗi biểu diễn số có kiểu double vào stringBuilder4
        StringBuilder stringBuilder4 = new StringBuilder("StringBuilder4");
        double doubleNumber = 6.1d;
        stringBuilder4.insert(14, doubleNumber);
        System.out.println("Kết quả chèn 1 chuỗi biểu diễn số có kiểu double: " + stringBuilder4);

        // chèn 1 chuỗi biểu diễn một mảng con của mảng ký tự str vào stringBuilder5
        StringBuilder stringBuilder5 = new StringBuilder("StringBuilder5");
        char[] str1 = {'d', 'a', 'b', 'c'};
        stringBuilder5.insert(5, str1, 1, 3);
        System.out.println("Kết quả chèn 1 chuỗi biểu diễn một mảng con của mảng ký tự str: " +
                stringBuilder5);
    }
}