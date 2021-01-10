import java.util.Scanner;

public class Main {

    public static boolean program = true;

    public static BankAccount bankAccount = new BankAccount();
    public static CardAccount cardAccount = new CardAccount();
    public static DepositAccount depositAccount = new DepositAccount();

    public static void main(String[] args) {

        while (program) {
            mainMenuView();
            Scanner in = new Scanner(System.in);
            String menuItem = in.next();

            mainMenuNavigation(menuItem);
        }
    }

    //дополнительные методы
    //отображение главного меню
    public static void mainMenuView() {
        System.out.println("Главное меню:");
        System.out.println("1 - Состояние счета");
        System.out.println("2 - Пополнить счет");
        System.out.println("3 - Снять наличные");
        System.out.println("4 - Перевод между счетами");
        System.out.println("\n0 - Выход");
    }

    //отображение меню состояния счета
    public static void balanceStateView() {
        System.out.println("Состояние счета:");
        System.out.println("Общий счет: " + bankAccount.getAmount() + " RUB");
        System.out.println("Счет карты: " + cardAccount.getAmount() + " RUB");
        System.out.println("Депозитный счет: " + depositAccount.getAmount() + " RUB");
        System.out.println("\n");
    }

    //отображение меню перевода между счетами
    public static void transferMenuView() {
        System.out.println("Перевод между счетами:");
        System.out.println("1 - Перевод с основного счета на карту");
        System.out.println("2 - Перевод с основного счета на депозитный счет");
        System.out.println("3 - Перевод с депозитного счета на основной счет");
        System.out.println("\n0 - Назад");
    }

    //навигация по главному меню
    public static void mainMenuNavigation(String menuItem) {
        switch (menuItem) {
            case "1":
                balanceStateView();
                break;

            case "2":
                putMoney();
                break;

            case "3":
                takeCash();
                break;

            case "4":
                transferMenuView();
                transferNavigation();
                break;

            case "0":
                program = false;
                break;

            default:
                getError();
                break;
        }
    }

    //пополнение счета
    public static void putMoney() {
        System.out.print("Введите сумму: ");
        Scanner input = new Scanner(System.in);
        double amountToPut = Double.parseDouble(input.next());

        bankAccount.put(amountToPut);
    }

    //снятие наличных
    public static void takeCash() {
        System.out.print("Введите сумму списания: ");
        Scanner input = new Scanner(System.in);
        double amountToPut = Double.parseDouble(input.next());

        cardAccount.take(amountToPut);
    }

    //перевод между счетами
    public static void transferNavigation() {

        Scanner in  = new Scanner(System.in);
        String submenuItem = in.next();

        switch (submenuItem) {
            case "1":
                bankToCardTransfer();
                break;

            case "2":
                bankToDepositTransfer();
                break;

            case "3":
                depositToBankTransfer();
                break;

            case "0":
                break;

            default:
                getError();
        }
    }

    //перевод с основного счета на карту
    public static void bankToCardTransfer() {
        System.out.println("Перевод с основного счета на карту:");
        System.out.print("Сумма перевода: ");

        Scanner in = new Scanner(System.in);
        double amountToCard = Double.parseDouble(in.next());

        if (amountToCard <= bankAccount.balance) {
            bankAccount.take(amountToCard);
            cardAccount.put(amountToCard);

        } else {
            System.out.println("Сумма списания больше суммы на счете!\n");
        }
    }

    //перевод с основного счета на депозитный счет
    public static void bankToDepositTransfer() {
        System.out.println("Перевод с основного счета на депозитный счет:");
        System.out.print("Сумма перевода: ");

        Scanner in = new Scanner(System.in);
        double amountToDeposit = Double.parseDouble(in.next());

        if (amountToDeposit <= bankAccount.balance) {
            bankAccount.take(amountToDeposit);
            depositAccount.put(amountToDeposit);

            System.out.println("Операция выполнена!\n");
        } else {
            System.out.println("Сумма списания больше суммы на счете!\n");
        }
    }

    //перевод с депозитного счета на основной счет
    public static void depositToBankTransfer() {
        System.out.println("Перевод с депозитного счета на основной счет:");
        System.out.print("Сумма перевода: ");

        Scanner in = new Scanner(System.in);
        double amountToBank = Double.parseDouble(in.next());

        if (amountToBank <= depositAccount.depositBalance) {
            depositAccount.take(amountToBank);
        }
    }


    //ошибка
    public static void getError() {
        System.out.println("Команда не распознана!\n");
    }
}
