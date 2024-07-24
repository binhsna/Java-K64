public class TestShareThread {
    public static void main(String[] args) {
        ShareThread shareThread = new ShareThread();

        Thread thread0 = new Thread(shareThread);
        thread0.setName("Luồng 1");
        thread0.start();

        Thread thread1 = new Thread(shareThread);
        thread1.setName("Luồng 2");
        thread1.start();

        Thread thread2 = new Thread(shareThread);
        thread2.setName("Luồng 3");
        thread2.start();

        System.out.println("Giá trị thuộc tính shareVariable = " + shareThread.getShareVariable());

    }
}
