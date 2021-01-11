import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DepositAccount extends BankAccount {

    public double depositBalance;
    public Calendar lastIncome;
    public Calendar dateOfWithdraw;

    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public double getAmount() {
        this.balance = depositBalance;
        return super.getAmount();
    }

    public void put(double amountToPut) {
        super.put(amountToPut);

        if (amountToPut > 0) {
            lastIncome = Calendar.getInstance();
            dateOfWithdraw = Calendar.getInstance();
            dateOfWithdraw.add(Calendar.MONTH, +1);

            this.depositBalance += amountToPut;
        } else {
            getNegativeAmountError();
        }
    }

    public void take(double amountToTake) {
        super.take(amountToTake);
        if (amountToTake <= depositBalance) {
            if (amountToTake >= 0) {
                Calendar now = Calendar.getInstance();

                if (now.after(dateOfWithdraw)) {

                    depositBalance -= amountToTake;
                } else {
                    System.out.println("Списание средств с депозитного счета в текущем месяце невозможно!");
                    System.out.println("Дата последнего пополнения: " + dateFormat.format(lastIncome.getTime()) + " г.");
                    System.out.println("Списание средств будет доступно не раньше " + dateFormat.format(dateOfWithdraw.getTime()) + " г.");
                }
            }
        } else {
            getMoreAmountError();
        }
    }
}
