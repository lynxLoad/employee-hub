public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        // Добавляем 11 сотрудников (10 должно добавиться, 11-й нет)
        System.out.println("=== Добавление сотрудников ===");
        Employee[] employees = {
                new Employee("Авилов Максим Николаевич", 1, 100),
                new Employee("Пунина Анастасия Сергеевна", 2, 200),
                new Employee("Сидорова Анна Сергеевна", 3, 300),
                new Employee("Козлов Дмитрий Андреевич", 4, 400),
                new Employee("Новикова Елена Владимировна", 5, 150),
                new Employee("Морозов Алексей Игоревич", 1, 250),
                new Employee("Волкова Мария Павловна", 2, 350),
                new Employee("Соколов Николай Александрович", 3, 50),
                new Employee("Лебедева Ольга Дмитриевна", 4, 175),
                new Employee("Виноградов Павел Сергеевич", 5, 450),
                new Employee("Кузнецова Татьяна Николаевна", 1, 325)
        };

        for (int i = 0; i < employees.length; i++) {
            boolean result = employeeBook.addEmployee(employees[i]);
            System.out.println("Добавление сотрудника " + (i + 1) + ": " + result);
        }

        System.out.println("\n=== Список всех сотрудников ===");
        employeeBook.printEmployeesInfo();

        System.out.println("\n=== Средняя зарплата ===");
        System.out.println("Средняя зарплата: " + employeeBook.getAverageSalary());

        System.out.println("\n=== Налоги (PROPORTIONAL) ===");
        employeeBook.printTaxes("PROPORTIONAL");

        System.out.println("\n=== Налоги (PROGRESSIVE) ===");
        employeeBook.printTaxes("PROGRESSIVE");

        System.out.println("\n=== Индексация зарплат отдела 1 на 10% ===");
        employeeBook.indexSalary(1, 10);
        System.out.println("После индексации:");
        employeeBook.printEmployeesInfo();

        System.out.println("\n=== Поиск первого сотрудника отдела 2 с зарплатой > 200 ===");
        employeeBook.printFirstEmployeeWithSalaryAbove(2, 200);

        System.out.println("\n=== Поиск первых 3 сотрудников с зарплатой < 300 ===");
        employeeBook.printFirstEmployeesWithSalaryBelow(300, 3);

        System.out.println("\n=== Проверка наличия сотрудника по зарплате ===");
        Employee testEmployee = new Employee("Тестов Тест Тестович", 1, 100);
        System.out.println("Есть сотрудник с зарплатой 100? " + employeeBook.containsEmployee(testEmployee));

        System.out.println("\n=== Поиск сотрудника по id ===");
        Employee foundEmployee = employeeBook.getEmployeeById(5);
        if (foundEmployee != null) {
            System.out.println("Найден сотрудник: " + foundEmployee);
        } else {
            System.out.println("Сотрудник с id=5 не найден");
        }

        Employee notFoundEmployee = employeeBook.getEmployeeById(99);
        if (notFoundEmployee != null) {
            System.out.println("Найден сотрудник: " + notFoundEmployee);
        } else {
            System.out.println("Сотрудник с id=99 не найден");
        }
    }
}