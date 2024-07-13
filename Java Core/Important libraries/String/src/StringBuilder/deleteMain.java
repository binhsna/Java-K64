package StringBuilder;

/*
Có 2 phương thức dùng để xóa ký tự đó là delete() và deleteCharAt()
*/
public class deleteMain {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("StringBuilder");

        // xóa các ký tự trong 1 chuỗi con của stringBuilder
        // Chuỗi con này bắt đầu tại chỉ số 3 và kéo dài đến ký tự có chỉ số 7
        stringBuilder.delete(3, 8);
        System.out.println("stringBuilder sau khi xóa là " + stringBuilder);

        // nếu chỉ số start = end thì sẽ không có bất kỳ 1 sự thay đổi nào
        stringBuilder.delete(3, 3);
        System.out.println("stringBuilder sau khi xóa là " + stringBuilder);

        // xóa 1 ký tự trong stringBuilder có chỉ số = 6 trong stringBuilder
        StringBuilder stringBuilder1 = new StringBuilder("StringBuilder1");
        stringBuilder1.deleteCharAt(7);
        System.out.println("stringBuilder sau khi xóa là " + stringBuilder1);
    }
}