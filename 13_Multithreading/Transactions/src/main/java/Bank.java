import java.util.*;

public class Bank {

    private static final Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud() throws InterruptedException {
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

            //инициализаия объекта класса проверки перевода
            TransferChecker transferChecker = new TransferChecker(fromAcc, toAcc, amount);

            synchronized (TransferChecker.class) {
                //вызов метода проверки счетов перед переводом
                transferChecker.checker();
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
            balance += getBalance(accountEntry.getValue().getAccNumber());
        }

        return balance;
    }

    //генератор аккаунтов
    public void accountGenerator(int count) {
        for (int i = 1; i <= count; i++) {
            //генерируем номер аккаунта от 100000 до 999999
            String accNumber = Integer.toString(random.nextInt(999999 - 100000) + 100000);
            //генерируем баланс аккаунта от 0 до 999999
            long money = random.nextInt(999999);
            Account account = new Account();                        //создаем аккаунт
            account.setAccNumber(accNumber);                        //назначаем номер аккаунта
            account.setMoney(money);                                //назначаем баланс
            accounts.put(accNumber, account);                       //добавляем аккаунт в список
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

        System.out.println("\nСумма денег на всех аккаунтах: " + getSumAllAccounts() + " RUB");
    }

    //получение случайного перевода между аккаунтами
    public synchronized void getRandomTransaction() throws InterruptedException {
        Random random = new Random();
        //создаем список ключей accounts
        List<String> keys = new ArrayList<>(accounts.keySet());

        String fromAccountNumber = keys.get(random.nextInt(keys.size()));   //произвольный номер аккаунта из списка
        String toAccountNumber = keys.get(random.nextInt(keys.size()));     //произвольный номер аккаунта из списка
        long amount = random.nextInt(99999);                         //произвольная сумма перевода

        //если номера равны (одинаковые аккаунты), то вызвать метод рекурсивно, чтобы исключить повторения
        if (fromAccountNumber.equals(toAccountNumber)) {
            getRandomTransaction();
        } else {
            //вызываем метод транзакций
            transfer(fromAccountNumber, toAccountNumber, amount);
        }
    }

    //выполнение транзакций в многопоточном режиме
    public void getTask(int iterations) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < iterations; i++) {
            Task task = new Task();
            threads.add(new Thread(task));
        }

        threads.forEach(Thread::start);
    }
}
