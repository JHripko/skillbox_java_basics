public class CardAccount extends BankAccount {

    protected double cardBalance;

    @Override
    protected double getAmount() {

        this.balance = cardBalance;
        return super.getAmount();
    }

    @Override
    protected void put(double amountToPut) {

        super.put(amountToPut);
        cardBalance = balance;
    }

    @Override
    protected void take(double amountToTake) {

        if (amountToTake > this.cardBalance) {
            getMoreAmountError();
        } else {
            //создаем переменную комиссии за перевод
            double percentToTake = amountToTake * 0.01;
            //прибавляем комиссию к сумме перевода
            amountToTake += percentToTake;
            //снова проверяем сумму списания с учетом комиссии
            if (amountToTake > this.cardBalance) {
                getMoreAmountError();
            } else {
                super.take(amountToTake);
                cardBalance = balance;
            }
        }
    }
}
