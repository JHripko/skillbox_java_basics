import java.util.Scanner;

public class Main {

    private static boolean program = true;

    private static Client physicalPerson = new PhysicalPerson();
    private static Client legalPerson = new LegalPerson();
    private static Client individualBusinessman = new IndividualBusinessman();

    public static void main(String[] args) {
        while (program) {
            mainMenuView();
            Scanner in = new Scanner(System.in);
            String menuItem = in.next().trim();

            mainMenuNavigation(menuItem);

        }
    }


    //дополнительные методы
    //отображение главного меню
    private static void mainMenuView() {
        System.out.println("Главное меню:");
        System.out.println("1 - Физ. лицо");
        System.out.println("2 - Юр. лицо");
        System.out.println("3 - ИП");
        System.out.println("4 - Баланс всех счетов");
        System.out.println("\n0 - Выход");
    }

    //отображение меню учетной записи
    private static void accountMenu(String nameOfAccount) {
        System.out.println(nameOfAccount + ":");
        System.out.println("1 - Состояние счета");
        System.out.println("2 - Пополнить счет");
        System.out.println("3 - Списание средств");
        System.out.println("\n0 - Назад");
    }


    //навигация по главному меню
    private static void mainMenuNavigation(String menuItem) {
        switch (menuItem) {
            case "1":
                accountMenu("Физ. лицо");
                accountMenuNavigation(physicalPerson);
                break;

            case "2":
                accountMenu("Юр. лицо");
                accountMenuNavigation(legalPerson);
                break;

            case "3":
                accountMenu("ИП");
                accountMenuNavigation(individualBusinessman);
                break;

            case "4":
                getAllAccountsBalance();
                break;

            case "0":
                program = false;
                break;

            default:
                getCommandError();
                break;
        }
    }

    //команды меню учетной записи
    private static void accountMenuNavigation(Client client) {
        Scanner in = new Scanner(System.in);
        String accountMenuItem = in.next().trim();

        switch (accountMenuItem) {
            case "1":
                getClientBalance(client);
                break;

            case "2":
                putAmountToClient(client);
                break;

            case "3":
                takeAmountFromClient(client);
                break;

            case "0":
                break;

            default:
                getCommandError();
        }
    }

    //отображение состояния счета
    private static void getClientBalance(Client client) {
        System.out.println("Состояние счета: " + client.getAmount());
    }

    //пополнение счета клиента
    private static void putAmountToClient(Client client) {
        System.out.println("Пополнение счета");
        System.out.print("Введите сумму: ");

        Scanner in = new Scanner(System.in);
        double amountToPut = Double.parseDouble(in.next());

        client.put(amountToPut);
    }

    //снятие средств со счета клиента
    private static void takeAmountFromClient(Client client) {
        System.out.println("Списание средств");
        System.out.print("Введите сумму: ");

        Scanner in = new Scanner(System.in);
        double amountToTake = Double.parseDouble(in.next());

        client.take(amountToTake);
    }

    //отображение состояния счета всех учетных записей
    private static void getAllAccountsBalance() {
        System.out.println("Баланс всех счетов");
        System.out.println("Физ. лицо: " + physicalPerson.getAmount() + " RUB");
        System.out.println("Юр. лицо: " + legalPerson.getAmount() + " RUB");
        System.out.println("ИП: " + individualBusinessman.getAmount() + " RUB\n");
    }


    //ошибка распознавания команды
    private static void getCommandError() {
        System.out.println("Команда не распознана!");
    }
}
