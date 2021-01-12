public class BankAccount {

    protected double balance;

    protected double getAmount() {

        return balance;
    }

    protected void put(double amountToPut) {
        //если сумма пополнения отрицательная - вывести ошибку
        if (amountToPut < 0) {
            getNegativeAmountError();
        } else {
            //пополнить баланс на указанную сумму
            balance += amountToPut;
            getSuccess();
        }
    }

    protected void take(double amountToTake) {
        //если сумма списания больше чем сумма на счете - вывести ошибку
        if (amountToTake > balance) {
            getMoreAmountError();
        } else {
            //если сумма списания отрицательная - вывести ошибку
            if (amountToTake < 0) {
                getNegativeAmountError();
            } else {
                //списать с баланса указанную сумму
                balance -= amountToTake;
            }
        }
    }

    //перевод между счетами
    protected boolean send(BankAccount receiver, double amount) {
        if (amount <= balance) {

            if (amount > 0) {
                //выполнить списание со счета суммы перевода
                take(amount);
                //пополнить счет на который переводят средства на сумму перевода
                receiver.put(amount);

                //вывести сообщение об успешной операции
                getSuccess();
                return true;
            } else {
                //вывести ошибку отрицательной суммы перевода
                getNegativeAmountError();
            }
        } else {
            //вывести ошибку суммы перевода превышающей суммы текущего счета
            getMoreAmountError();
        }
        return false;
    }

    //дополнительные методы
    //сообщение об успешной операции
    protected void getSuccess() {
        System.out.println("Операция выполнена!\n");
    }
    //ошибка отрицательной суммы
    protected static void getNegativeAmountError() {
        System.out.println("Нельзя положить отрицательную сумму!\n");
    }

    //ошибка списание суммы больше чем на счете
    protected static void getMoreAmountError() {
        System.out.println("Сумма списания больше суммы на счете!\n");
    }
}
