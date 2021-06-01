public class Task implements Runnable {
    Bank bank = new Bank();

    @Override
    public void run() {
        try {
            bank.getRandomTransaction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
