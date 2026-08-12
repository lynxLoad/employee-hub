import java.util.Objects;

public class Employee {
    private static int counter = 0;

    private final int id;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String fullName, int department, int salary) {
        this.id = counter;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;

        counter++;
    }

    public int getId() { return id; }

    public String getFullName() { return fullName; }

    public int getDepartment() { return department; }

    public int getSalary() { return salary; }

    public void setDepartment(int department) { this.department = department; }

    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "идентификатор=" + id +
                ", ФИО='" + fullName + '\'' +
                ", отдел=" + department +
                ", зарплата=" + salary +
                '}';
    }

    public void printShortInfo() {
        System.out.println("Сотрудник{" +
                "ФИО='" + fullName + '\'' +
                ", зарплата=" + salary +
                '}');
    }
}
