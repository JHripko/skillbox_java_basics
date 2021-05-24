import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)) {
            Account fromAcc = accounts.get(fromAccountNum);
            Account toAcc = accounts.get(toAccountNum);

            //проверяем не заблокированы ли аккаунты
            if (fromAcc.isActive() && toAcc.isActive()) {
                //если достаточно денег для перевода
                if (fromAcc.getMoney() >= amount) {
                    //если сумма перевода > 50000 то передаем на проверку
                    if (amount > 50000) {
                        //если мошенничество подтверждено, то блокируем счета
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            fromAcc.setActive(false);
                            toAcc.setActive(false);
                        } else {
                            getTransfer(fromAcc, toAcc, amount);
                        }
                    } else {
                        getTransfer(fromAcc, toAcc, amount);
                    }
                } else {
                    System.out.println("Операция не выполнена: " +
                            "На счете " + fromAccountNum + " недостаточно денег для перевода!");
                }
            } else {
                System.out.println("Операция не выполнена: Один из счетов заблокирован!");
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        if (accounts.containsKey(accountNum)) {
            return accounts.get(accountNum).getMoney();
        } else return 0;
    }

    public long getSumAllAccounts() {
        long balance = 0;
        for (Map.Entry<String, Account> accountEntry : accounts.entrySet()) {
            balance += accountEntry.getValue().getMoney();
        }

        return balance;
    }

    //генератор аккаунтов
    public void accountGenerator(int count) {
        for (int i = 1; i <= count; i++) {
            //генерируем номер аккаунта от 100000 до 999999
            String accNumber = Integer.toString(random.nextInt(999999 - 100000) + 100000);
            //генерируем баланс аккаунта от 0 до 9999999
            long money = random.nextInt(9999999);
            Account account = new Account();    //создаем аккаунт
            account.setAccNumber(accNumber);    //назначаем номер аккаунта
            account.setMoney(money);            //назначаем баланс
            accounts.put(accNumber, account);   //добавляем аккаунт в список
        }

        //отображение списка аккаунтов
        getAccountsList();
    }

    //отображение списка аккаунтов
    public void getAccountsList() {
        for (Map.Entry<String, Account> accountEntry : accounts.entrySet()) {
            System.out.println("Номер аккаунта: " + accountEntry.getKey() +
                    " Баланс: " + accountEntry.getValue().getMoney() + " RUB");
        }
    }

    //перевод средств
    public void getTransfer(Account fromAcc, Account toAcc, long amount) {
        fromAcc.setMoney(-amount);
        toAcc.setMoney(amount);
        System.out.println("Операция выполнена!\n" +
                "Счет " + fromAcc.getAccNumber() + " остаток: " + getBalance(fromAcc.getAccNumber()) +
                "Счет " + toAcc.getAccNumber() + " остаток: " + getBalance(toAcc.getAccNumber()));
    }
}
