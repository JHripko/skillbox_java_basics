import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DepositAccount extends BankAccount {

    public double depositBalance;
    public LocalDate lastIncome;
    public LocalDate dateOfWithdraw = LocalDate.now();

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public double getAmount() {
        this.balance = depositBalance;
        return super.getAmount();
    }

    public void put(double amountToPut) {
        super.put(amountToPut);

        if (amountToPut > 0) {
            LocalDate now = LocalDate.now();
            lastIncome = now;
            dateOfWithdraw = lastIncome.plusMonths(1);

            this.depositBalance += amountToPut;
        } else {
            getNegativeAmountError();
        }
    }

    public void take(double amountToTake) {
        super.take(amountToTake);
        if (amountToTake <= depositBalance) {
            if (amountToTake >= 0) {
                LocalDate now = LocalDate.now();

                if (now.compareTo(dateOfWithdraw) >= 0) {
                    depositBalance -= amountToTake;
                } else {
                    System.out.println("Списание средств с депозитного счета в текущем месяце невозможно!");
                    System.out.println("Списание средств будет доступно не раньше " + dateFormat.format(dateOfWithdraw) + " г.");
                }
            }
        } else {
            getMoreAmountError();
        }
    }
}
