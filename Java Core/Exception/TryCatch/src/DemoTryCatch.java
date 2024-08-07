
public class DemoTryCatch {
    public static void main(String[] args) {
        try {
            int a[] = new int[7];
            a[4] = 30 / 0;
            System.out.println("Câu lệnh in đầu tiên trong try block");
        } catch (ArithmeticException e) {
            System.out.println("Cảnh báo: ngoại lệ ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cảnh báo: ngoại lệ ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Cảnh báo: ngoại lệ khác");
            e.printStackTrace();
        }
        System.out.println("Ra khỏi try-catch block...");
    }
}