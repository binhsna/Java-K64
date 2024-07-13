package StringBuilder;

/*
StringBuilder được sử dụng để quản lý một chuỗi
mà có thể thay đổi kích thước và nội dung.
 */
public class Main {
    public static void main(String[] args) {
        // Dạng 1: tạo 1 StringBuilder rỗng có khả năng lưu trữ 16 ký tự (Mặc định).
        StringBuilder stringBuilder = new StringBuilder();

        // Dạng 2: tạo 1 StringBuilder rỗng có khả năng lưu trữ số ký tự = 32
        StringBuilder stringBuilder1 = new StringBuilder(32);

        // Dạng 3: tạo 1 StringBuilder từ 1 chuỗi str có sẵn
        // khả năng lưu trữ của stringBuilder2 = 16 + chiều dài của chuỗi
        String str = "Hello World!";
        StringBuilder stringBuilder2 = new StringBuilder(str);
    }
}