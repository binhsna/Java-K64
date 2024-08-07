package Finally;

/*
* Các trường hợp khi finally block không được thực hiện.
- Các trường hợp ngăn code thực thi trong một finally block:
--> Một thread bị ngừng.
--> Sử dụng phương thức System.exit().
--> Do một exception phát sinh trong finally block.
* */
public class JavaFinally {
    public static void main(String args[]) {
        System.out.println(JavaFinally.myMethod());
        //=> Finally thường được dùng để dọn dẹp, đóng các tiến trình (thread) khi không cần dùng đến nữa
        
    }

    public static int myMethod() {
        try {
            return 112;
        } finally {
            System.out.println("Đây là finally block");
            System.out.println("Finally block vẫn chạy mặc dù lệnh return trong try block đã được thực thi trước");
        }
    }
}