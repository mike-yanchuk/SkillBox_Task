import java.util.Comparator;

public class EmployeeComparator implements Comparator, Employee {
    @Override
    public double getMonthSalary() {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return Double.compare(((Employee) o1).getMonthSalary(),((Employee) o2).getMonthSalary());
    }

    //    @Override
//    public int compare(Object o1, Object o2) {
//        return Integer.compare(((Employee) o1).getMonthSalary(),((Employee) o2).getMonthSalary());
//    }
}
