import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DepositAccount extends BankAccount {

    public double depositBalance;
    public Calendar lastIncome = Calendar.getInstance();            //дата последнего пополнения
    public Calendar dateOfWithdraw = Calendar.getInstance();        //дата когда возможно списание с депозита
    boolean isDateToWithdraw = true;                                /*вспомогательная переменная возможности списания
                                                                    с депозита */

    //формат даты для отображения в сообщении
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public double getAmount() {
        this.balance = depositBalance;
        return super.getAmount();
    }

    public void put(double amountToPut) {

        if (amountToPut > 0) {
            //обновляем текущую дату внесения средств на депозитный счет
            lastIncome = Calendar.getInstance();
            //вычисляем дату после которой возможно списание средств с депозитного счета
            dateOfWithdraw = lastIncome;
            dateOfWithdraw.add(Calendar.MONTH, +1);

            //меняем значение переменной, т.к. списание уже доступно будет только через месяц
            isDateToWithdraw = false;

            super.put(amountToPut);
            depositBalance = balance;
        } else {
            getNegativeAmountError();
        }
    }

    public void take(double amountToTake) {

        if (amountToTake <= depositBalance) {
            if (amountToTake >= 0) {
                //текущая дата попытки списания средств
                Calendar now = Calendar.getInstance();

                //проверка возможности списания
                if (isPossibleToWithdraw(now, dateOfWithdraw)) {

                    super.take(amountToTake);
                    depositBalance = balance;
                } else {
                    getDateOfWithdrawError();
                }
            }
        } else {
            getMoreAmountError();
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        this.balance = depositBalance;
        if (isDateToWithdraw) {
            return super.send(receiver, amount);
        }
        getDateOfWithdrawError();
        return false;
    }


    //дополнительные методы
    //проверка возможности списания
    public boolean isPossibleToWithdraw(Calendar now, Calendar dateOfWithdraw) {
        //если пытаемся списать средства после возможной даты списания то разрешаем списания средств
        if (now.after(dateOfWithdraw)) {
            isDateToWithdraw = true;
        } else {
            isDateToWithdraw = false;
        }

        return isDateToWithdraw;
    }

    //ошибка невозможности списания
    public void getDateOfWithdrawError() {
        System.out.println("Списание средств с депозитного счета в текущем месяце невозможно!");
        System.out.println("Дата последнего пополнения: " + dateFormat.format(lastIncome.getTime()) + " г.");
        System.out.println("Списание средств будет доступно не раньше " + dateFormat.format(dateOfWithdraw.getTime()) + " г.");
    }
}
