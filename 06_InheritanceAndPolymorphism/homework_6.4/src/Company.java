import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();            //список сотрудников
    private List<Integer> listOfProfits = new ArrayList<>();            //список доходов от каждого сотрудника


    //найм одного сотрудника
    public void hire(Employee employee){
        employeeList.add(employee);
    }

    //найм списка сотрудников
    public void hireAll(Company company, int operatorCount, int managerCount, int topManagerCount) {
        for (int i = 0; i < operatorCount; i++) {
            Operator operator = new Operator(30000, company);
            employeeList.add(operator);
        }

        for (int i = 0; i < managerCount; i++) {
            Manager manager = new Manager(50000, company);
            employeeList.add(manager);
        }

        for (int i = 0; i < topManagerCount; i++) {
            TopManager topManager = new TopManager(100000, company);
            employeeList.add(topManager);
        }
    }

    //увольнение сотрудника
    public void fire(int index) {
        if (employeeList.contains(index)) {
            employeeList.remove(index);
        } else {
            System.out.println("Сотрудника с таким ID не существует!");
        }
    }

    //увольнение половины сотрудников (случайных)
    public void fireOffHalf() {
        //вычисляем количество половины сотрудников
        int count = (int) (employeeList.size() * 0.5);

        for (int i = 0; i < count; i++) {
            //генерируем индекс случайного сотрудника
            int index = (int) (Math.random() * employeeList.size());
            employeeList.remove(index);
        }
    }

    //добавление дохода в список дохода от каждого сотрудника
    public void addProfit(int profit) {
        listOfProfits.add(profit);
    }

    //получение списка сотрудников
    public void getEmployeeList() {
        int i = 0;
        for (Employee employee : employeeList) {
            System.out.println(i + " - " + employee.getClass() + " доход компании: "
                    + employee.getProfitForCompany() + " RUB зарплата: "
                    + employee.getMonthSalary() + " RUB");

            i++;
        }
    }

    //получение списка доходов от каждого сотрудника
    public void getProfitList() {
        for (Integer profit : listOfProfits) {
            System.out.println(profit + " RUB");
        }
    }

    //получение списка зарплат по возрастанию
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> salaryList = new ArrayList<>();

        employeeList.sort((o1, o2) -> Integer.compare(o2.getMonthSalary(), o1.getMonthSalary()));

        if (count >= employeeList.size()) {
            salaryList.addAll(employeeList);
        }
        if (count < employeeList.size()) {
            for (int i = 0; i < count; i++) {
                salaryList.add(i, employeeList.get(i));
            }
        }

        return salaryList;
    }

    //получение списка зарплат по убыванию
    public List<Employee> getLowerSalaryStuff(int count) {
        List<Employee> salaryList = new ArrayList<>();

        employeeList.sort((o1, o2) -> Integer.compare(o1.getMonthSalary(), o2.getMonthSalary()));

        if (count >= employeeList.size()) {
            salaryList.addAll(employeeList);
        }
        if (count < employeeList.size()) {
            for (int i = 0; i < count; i++) {
                salaryList.add(i, employeeList.get(i));
            }
        }

        return salaryList;
    }

    //получение дохода компании
    public int getIncome() {
        int companyIncome = 0;
        for (Employee employee : employeeList) {
            companyIncome += employee.getProfitForCompany();
        }

        return companyIncome;
    }

    //получение кол-ва сотрудников компании
    public int getCompanySize() {
        return employeeList.size();
    }
}
