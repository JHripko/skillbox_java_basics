public class Operator implements Employee {

    private int salary;
    private int profit;

    public Operator(int startSalary, Company company) {
        profit =(int) (Math.random() * 25000) + 115000;

        company.addProfit(getProfitForCompany());

        this.salary = startSalary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public int getProfitForCompany() {
        return profit;
    }
}
