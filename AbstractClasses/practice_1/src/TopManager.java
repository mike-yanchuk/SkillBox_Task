public class TopManager implements Employee{
    private Company company;
    public TopManager(Company company) {
        this.company = company;
    }


    @Override
    public double getMonthSalary() {
        if(company.getIncome() >= 10_000_000){
            int bonus = salary / 100 * 150;
            return salary + bonus;
        } else return salary;
    }

    @Override
    public String toString() {
        return "" + getMonthSalary();
    }
}
