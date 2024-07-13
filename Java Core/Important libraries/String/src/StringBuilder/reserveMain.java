package StringBuilder;

/*
Phương thức reserve() là phương thức dùng để đảo ngược các ký tự của StringBuilder
*/
public class reserveMain {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("StringBuilder");

        stringBuilder.reverse();
        System.out.println("stringBuilder sau khi đảo ngược các ký tự là " + stringBuilder);
    }
}
