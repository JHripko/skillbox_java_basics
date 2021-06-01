import java.util.Scanner;

public class Main {
    public static Bank bank = new Bank();
    public static void main(String[] args) {
        System.out.print("Введите кол-во аккаунтов, которое будет сгенерированно: ");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        //передаем кол-во генерируемых аккаунтов
        bank.accountGenerator(count);

        System.out.print("\nСколько итераций выполнить? Кол-во итераций: ");
        int iterations = in.nextInt();

        //передаем кол-во итераций по транзакциям между аккаунтами
        bank.getTask(iterations);
    }
}
