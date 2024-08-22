public class Manager implements Employee{
    private Company company;

    public Manager(Company company) {
        this.company = company;
        company.increaseIncome(getMonthSalary());
    }
    protected int earnedMoneyCompany = 115_000 + (int) Math.round(25_000 * Math.random());
    protected int bonus = earnedMoneyCompany / 100 * 5;
    @Override
    public double getMonthSalary() {
        return salary + bonus;
    }

    public int getAllEarnedMoneyCompany() {
        return earnedMoneyCompany;
    }


    @Override
    public String toString() {
        return "" + getMonthSalary() + " ";
    }
}
