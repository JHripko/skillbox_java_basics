public class Manager implements Employee {

    private int salary;
    private int profit;

    public Manager(int startSalary, Company company) {
        profit = (int) (Math.random() * 25000) + 115000;

        company.addProfit(getProfitForCompany());

        int percent = (int) (profit * 0.05);
        this.salary = startSalary + percent;
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
