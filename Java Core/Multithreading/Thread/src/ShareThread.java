public class ShareThread implements Runnable {
    private int shareVariable = 0;  // thuộc tính sử dụng chung

    public int getShareVariable() {
        return shareVariable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("ID:" + Thread.currentThread().getId() +
                    ", Name: " + Thread.currentThread().getName()
                    + ", shareVariable = " + shareVariable);
            shareVariable += 2;
        }
    }
}
