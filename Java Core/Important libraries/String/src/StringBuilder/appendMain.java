package StringBuilder;

/*
Phương thức append() là phương thức dùng để nối chuỗi thay thế cho dấu "+"
*/
public class appendMain {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            stringBuilder.append("Hello lần " + i);
            stringBuilder.append("\t\n"); // nối "\t" vào cuối stringBuilder
        }

        System.out.println(stringBuilder);
    }
}