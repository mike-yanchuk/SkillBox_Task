import java.util.*;

public class Company {

    private double incom = 0;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> employeesСonclusion;
    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        for (Employee employee : employees) {
            this.employees.add(employee);
        }
    }

    public void fire(Employee employee) {
        this.employees.remove(employee);
    }

    public double getIncome(){
        return incom;
    }

    public List<Employee> getTopSalaryStaff(int count){
        employeesСonclusion = new ArrayList<>();
        for (int i = 1; i < count + 1; i++) {
            employeesСonclusion.add(employees.get(employees.size() - i));
        }

        return employeesСonclusion;
    }


    public List<Employee> getLowestSalaryStaff(int count){
        employeesСonclusion = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            employeesСonclusion.add(employees.get(i));
        }
        return employeesСonclusion;
    }

    public void increaseIncome(double manager){
        incom += incom + manager;
    }


    @Override
    public String toString() {
        return " ";
    }
}
