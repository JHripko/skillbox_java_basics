public class CardAccount extends BankAccount {

    public double cardBalance;

    @Override
    public double getAmount() {
        this.balance = cardBalance;
        return super.getAmount();
    }

    public void put(double amountToPut) {
        super.put(amountToPut);
        cardBalance = this.balance;
    }

    public void take(double amountToTake) {
        super.take(amountToTake);
        if (amountToTake > this.cardBalance) {
            getMoreAmountError();
        } else {
            double percentToTake = amountToTake * 0.01;
            amountToTake += percentToTake;
            if (amountToTake > this.cardBalance) {
                getMoreAmountError();
            } else {
                this.cardBalance -= amountToTake;
                System.out.println("Операция выполнена!\n");
            }
        }
    }
}
