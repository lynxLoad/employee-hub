public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public EmployeeBook() {
    }

    public void printEmployeesInfo() {
        for (Employee e : employees) {
            if (e != null) { // ?
                System.out.println(e);
            }
        }
    }

    public double getAverageSalary() {
        int validSalaryCount = 0;
        double salarySum = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                validSalaryCount++;
                salarySum += employees[i].getSalary();
            }
        }

        if (validSalaryCount == 0) {
            return 0.0;
        }

        return salarySum / validSalaryCount;
    }

    private double calculateTax(int salary, String taxType) {
        switch (taxType.toUpperCase()) {
            case "PROPORTIONAL":
                return calculateProportionalTax(salary);

            case "PROGRESSIVE":
                return calculateProgressiveTax(salary);

            default:
                throw new IllegalArgumentException("Неизвестный тип налога: " + taxType);
        }
    }

    private double calculateProportionalTax(int salary) {
        return salary * 0.13;
    }

    private double calculateProgressiveTax(int salary) {
        double tax;

        if (salary <= 150) {
            tax = salary * 0.13;
        } else if (salary <= 350) {
            tax = salary * 0.17;
        } else {
            tax = salary * 0.21;
        }

        return tax;
    }

    public void printTaxes(String taxType) {
        for (Employee e : employees) {
            if (e != null) {
                double tax = calculateTax(e.getSalary(), taxType);
                System.out.println(e.getFullName() + ": зарплата " + e.getSalary() + ", налог " + tax);
            }
        }
    }

    public void indexSalary(int department, double indexPercent) {
        for (Employee e : employees) {
            if (e == null) { continue; }
            if (e.getDepartment() != department) { continue; }

            int salary = e.getSalary();
            int newSalary = (int) (salary * (1 + indexPercent / 100));
            e.setSalary(newSalary);
        }
    }

    public void printFirstEmployeeWithSalaryAbove(int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) { continue; }
            if (e.getDepartment() != department) { continue; }

            if (e.getSalary() > salary) {
                System.out.print("Порядковый номер: " + (i + 1) + " - ");
                e.printShortInfo();
                break;
            }
        }
    }

    public void printFirstEmployeesWithSalaryBelow(int wage, int employeeNumber) {
        int counter = 0;
        int i = 0;

        while (i < employees.length) {
            Employee e = employees[i];

            if (e != null && e.getSalary() < wage) {
                e.printShortInfo();
                counter++;

                if (counter >= employeeNumber) {
                    break;
                }
            }

            i++;
        }
    }

    public boolean containsEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e != null && e.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}























