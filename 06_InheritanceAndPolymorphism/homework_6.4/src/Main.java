public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        Company company1 = new Company();
        //найм по одному
        company1.hire(new Operator(30000, company));
        company1.hire(new Operator(25000, company));
        company1.hire(new Operator(25000, company));
        company1.hire(new Operator(25000, company));
        company1.hire(new Operator(25000, company));
        company1.hire(new Operator(25000, company));
        company1.hire(new Manager(40000, company));
        company1.hire(new Manager(45000, company));
        company1.hire(new TopManager(50000, company));
        company1.hire(new TopManager(60000, company));

        //найм списка сотрудников
        company.hireAll(company, 180, 80, 10);

        //отобразить список сотрудников
        company.getEmployeeList();

        //отобразить список доходов от каждого сотрудника
//        company.getProfitList();

        //список самых высоких зарплат
        getTopList(company, 15);

        //список самых низких зарплат
        getLowerList(company, 30);

        getCountOfEmployee(company);
        getCompanyProfit(company);

        //увольнение сотрудника
        company1.fire(10);
        company1.getEmployeeList();

        //уволить половину сотрудников
        company.fireOffHalf();
        company.getEmployeeList();
        //список самых высоких зарплат
        getTopList(company, 15);

        //список самых низких зарплат
        getLowerList(company, 30);

        getCountOfEmployee(company);
    }


    //дополнительные методы
    //отображение списка самых высоких зарплат
    public static void getTopList(Company company, int count) {
        int i = 0;

        System.out.println("Самые высокие зарплаты:");
        for (Employee employee : company.getTopSalaryStaff(count)) {
            System.out.println(i + " - " + employee.getClass() + " зарплата: " + employee.getMonthSalary() + " RUB");
            i++;
        }
    }

    //отображение списка самых низких зарплат
    public static void getLowerList(Company company, int count) {
        int i = 0;

        System.out.println("Самые низкие зарплаты:");
        for (Employee employee : company.getLowerSalaryStuff(count)) {
            System.out.println(i + " - " + employee.getClass() + " зарплата: " + employee.getMonthSalary() + " RUB");
            i++;
        }
    }

    //отображение кол-ва сотрудников
    public static void getCountOfEmployee(Company company) {
        System.out.println("Кол-во сотрудников: " + company.getCompanySize());
    }

    //отображение дохода компании
    public static void getCompanyProfit(Company company) {
        System.out.println("\nОбший доход компании: " + company.getIncome() + " RUB");
    }
}
