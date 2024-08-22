import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Employee> listEmployee = new ArrayList<>();

        for (int i = 0; i < 180 ; i++) {
            listEmployee.add(new Operator(company));
        }
        for (int i = 0; i < 80; i++) {
            listEmployee.add(new Manager(company));
        }

        for (int i = 0; i < 10; i++) {
            listEmployee.add(new TopManager(company));
        }
        Collections.sort(listEmployee, new EmployeeComparator());
        company.hireAll(listEmployee);
        System.out.println("Самые высокооплачиваемые сотрудники: " + company.getTopSalaryStaff(15));
        System.out.println("Самые низкооплачиваемые сотрудники: " + company.getLowestSalaryStaff(30));
        Collections.shuffle(listEmployee);

        for (int i = 0; i < listEmployee.size() / 2; i++) {
            company.fire(listEmployee.get(i));
        }

        Collections.sort(listEmployee, new EmployeeComparator());
        System.out.println("Самые высокооплачиваемые сотрудники: " + company.getTopSalaryStaff(15));
        System.out.println("Самые низкооплачиваемые сотрудники: " + company.getLowestSalaryStaff(30));
        System.out.println("Доход компании: " + company.getIncome());
    }

}
