
public class Example4 {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
