public class TopManager implements Employee {

    private int salary;
    private int profit;

    public TopManager(int startSalary, Company company) {
        profit = (int) (Math.random() * 25000) + 115000;

        company.addProfit(getProfitForCompany());

        if (company.getIncome() > 10000000) {
            int percent = (int) (startSalary * 1.5);
            this.salary = startSalary + percent;
        } else {
            this.salary = startSalary;
        }
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
