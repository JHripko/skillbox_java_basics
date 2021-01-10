public class BankAccount {

    public double balance;

    public double getAmount() {

        return balance;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            getNegativeAmountError();
        } else {
            balance += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake > balance) {
            getMoreAmountError();
        } else {
            if (amountToTake < 0) {
                getNegativeAmountError();
            } else {
                balance -= amountToTake;
            }
        }
    }

    //дополнительные методы
    //ошибка отрицательной суммы
    public static void getNegativeAmountError() {
        System.out.println("Нельзя положить отрицательную сумму!\n");
    }

    //ошибка списание суммы больше чем на счете
    public static void getMoreAmountError() {
        System.out.println("Сумма списания больше суммы на счете!\n");
    }
}
