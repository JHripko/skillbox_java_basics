public class TransferChecker {
    Account fromAcc;
    Account toAcc;
    long amount;

    public TransferChecker(Account fromAcc, Account toAcc, long amount) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
    }

    //проверка перевода
    public void checker() throws InterruptedException {
        Bank bank = new Bank();

        //сообщение о начале операции
        operationMsg();

        //если оба счета не заблокированы
        if (isActive()) {
            //если сумма перевода не превышает сумму на счете
            if (!isLargeAmount()) {
                //если сумма перевода > 50000
                if (isLimit()) {
                    //присваиваем статус активности счетам по решению метода isFraud()
                    boolean status = bank.isFraud();
                    fromAcc.setActive(status);
                    toAcc.setActive(status);

                    //повторно проверяем активность счетов
                    if (isActive()) {
                        //выполнение перевода
                        getTransfer();
                        //сообщение об успешном переводе
                        successMsg();
                    } else {
                        //сообщение о блокировке счетов по подозрительной операции
                        fraudMsg();
                    }
                } else {
                    //выполнение перевода
                    getTransfer();
                    //сообщение об успешном переводе
                    successMsg();
                }
            } else {
                //сообщение о том что сумма перевода больше суммы на счете
                largeAmountMsg();
            }
        } else {
            //сообщение о заблокированных счетах
            blockedMsg();
        }
    }

    //проверка активности счетов (активен или заблокирован)
    public boolean isActive() {
        return (fromAcc.isActive() && toAcc.isActive());
    }

    //проверка не превышает ли сумма перевода суммы на счете
    public boolean isLargeAmount() {
        return (amount > fromAcc.getMoney());
    }

    //проверка не превышает ли сумма списания 50000
    public boolean isLimit() {
        return (amount >= 50000);
    }

    //выполнение перевода
    public void getTransfer() {
        fromAcc.setMoney(fromAcc.getMoney() - amount);
        toAcc.setMoney(toAcc.getMoney() + amount);
    }


    //сообщение об успешном переводе
    public void successMsg() {
        System.out.println("\t*** Операция выполнена ***" +
                "\n\tСчет " + fromAcc.getAccNumber() + " остаток: " + fromAcc.getMoney() +
                "\n\tСчет " + toAcc.getAccNumber() + " остаток: " + toAcc.getMoney() + "\n");
    }

    //сообщение о заблокированных счетах
    public void blockedMsg() {
        System.out.println("\t*** Операция не выполнена! Один или оба счета заблокированы\n");
    }

    //сообщение о том что сумма перевода больше суммы на счете
    public void largeAmountMsg() {
        System.out.println("\t*** Операция не выполнена! Сумма перевода (" + amount + " RUB) больше суммы на счете " +
                fromAcc.getAccNumber() + "\n");
    }

    //сообщение о подозрительной операции и блокировке счетов
    public void fraudMsg() {
        System.out.println("\t*** Anti-Fraud: Подозрительная операция. Оба счета заблокированы\n");
    }

    //сообщение о начале операции
    public void operationMsg() {
        System.out.println("\n=== Перевод средств ===" +
                "\nСчет отправителя: " + fromAcc.getAccNumber() + " (" + fromAcc.getMoney() + " RUB)" +
                "\nСчет получателя: " + toAcc.getAccNumber() + " (" + toAcc.getMoney() + " RUB)" +
                "\nСумма перевода: " + amount + " RUB\n");
    }
}
