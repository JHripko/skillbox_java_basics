public abstract class Client {

    private double balance;

    protected double getAmount() {
        return balance;
    }

    protected void put(double amountToPut) {
        if (amountToPut >= 0) {
            balance += amountToPut;
            getSuccessMessage();
        } else {
            getNegativeAmountError();
        }
    }

    protected void take(double amountToTake) {
        if (amountToTake >= 0) {
            if (amountToTake <= balance) {
                balance -= amountToTake;
                getSuccessMessage();
            } else {
                getMoreAmountError();
            }
        } else {
            getNegativeAmountError();
        }
    }


    //дополнительные методы
    //ошибка операции с отрицательной суммой
    protected void getNegativeAmountError() {
        System.out.println("Нельзя перевести отрицательную сумму!");
    }

    //ошибка операции с суммой превышающей сумму на счете
    protected void getMoreAmountError() {
        System.out.println("Сумма списания больше суммы на счете!");
    }

    //сообщение об успешной операции
    protected void getSuccessMessage() {
        System.out.println("Операция выполнена!");
    }

}
