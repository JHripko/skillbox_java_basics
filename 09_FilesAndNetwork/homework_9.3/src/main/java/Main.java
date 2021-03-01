import java.text.NumberFormat;

public class Main {

    public static final String MOVEMENT_LIST = "../files/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(MOVEMENT_LIST);
        //формат отображения суммы
        NumberFormat f = NumberFormat.getInstance();
        System.out.println("Сумма расходов: " + f.format(movements.getExpenseSum()) + " руб");
        System.out.println("Сумма доходов: " + f.format(movements.getIncomeSum()) + " руб");
        System.out.println("\nСуммы расходов по организациям:");
        movements.getCompanyList();
    }
}
