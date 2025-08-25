import java.util.Scanner;

// ---------------- Employee Class ----------------
class Employee {
    // Static variables (shared by all employees)
    private static String companyName;
    private static int totalEmployees = 0;

    // Instance variables (unique per employee)
    private int empId;
    private String name;
    private String department;
    private double salary;

    // Default constructor
    public Employee() {
        this.empId = ++totalEmployees;
        this.name = "Unknown";
        this.department = "Unassigned";
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, String department, double salary) {
        this.empId = ++totalEmployees;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static String getCompanyName() {
        return companyName;
    }

    // Instance methods
    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void displayEmployee() {
        System.out.println("[" + empId + "] " + name + " | Dept: " + department +
                " | Salary: $" + salary + " | Annual: $" + calculateAnnualSalary());
    }

    // Getters
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// ---------------- Department Class ----------------
class Department {
    private String deptName;
    private Employee[] employees;
    private int employeeCount;

    // Constructor
    public Department(String deptName, int capacity) {
        this.deptName = deptName;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }

    // Add employee
    public void addEmployee(Employee emp) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = emp;
            System.out.println("Employee added to " + deptName);
        } else {
            System.out.println("Department is full!");
        }
    }

    // Display all employees
    public void displayEmployees() {
        System.out.println("=== " + deptName + " Department Employees ===");
        if (employeeCount == 0) {
            System.out.println("No employees in this department.");
            return;
        }
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployee();
        }
    }

    // Find highest paid employee in department
    public Employee highestPaid() {
        if (employeeCount == 0) return null;
        Employee highest = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > highest.getSalary()) {
                highest = employees[i];
            }
        }
        return highest;
    }

    // Calculate total payroll
    public double totalPayroll() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    // Getters
    public String getDeptName() { return deptName; }
    public int getEmployeeCount() { return employeeCount; }
    public Employee[] getEmployees() { return employees; }
}

// ---------------- Main Application ----------------
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup company
        System.out.print("Enter Company Name: ");
        String cname = scanner.nextLine();
        Employee.setCompanyName(cname);

        // Create departments
        Department hr = new Department("HR", 10);
        Department it = new Department("IT", 10);
        Department sales = new Department("Sales", 10);

        int choice;
        do {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM (" + Employee.getCompanyName() + ") ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Department Statistics");
            System.out.println("5. Company Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department (HR/IT/Sales): ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    Employee emp = new Employee(name, dept, salary);
                    if (dept.equalsIgnoreCase("HR")) hr.addEmployee(emp);
                    else if (dept.equalsIgnoreCase("IT")) it.addEmployee(emp);
                    else if (dept.equalsIgnoreCase("Sales")) sales.addEmployee(emp);
                    else System.out.println("Invalid department.");
                    break;

                case 2: // Display All Employees
                    hr.displayEmployees();
                    it.displayEmployees();
                    sales.displayEmployees();
                    break;

                case 3: // Search Employee
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    Department[] depts = {hr, it, sales};
                    for (Department d : depts) {
                        for (Employee e : d.getEmployees()) {
                            if (e != null && e.getName().equalsIgnoreCase(searchName)) {
                                System.out.println("Found in " + d.getDeptName() + " Department:");
                                e.displayEmployee();
                                found = true;
                            }
                        }
                    }
                    if (!found) System.out.println("Employee not found.");
                    break;

                case 4: // Department Statistics
                    Department[] deptArray = {hr, it, sales};
                    for (Department d : deptArray) {
                        System.out.println("\n--- " + d.getDeptName() + " Department ---");
                        System.out.println("Employees: " + d.getEmployeeCount());
                        System.out.println("Total Payroll: $" + d.totalPayroll());
                        Employee highest = d.highestPaid();
                        if (highest != null) {
                            System.out.print("Highest Paid: ");
                            highest.displayEmployee();
                        }
                    }
                    break;

                case 5: // Company Statistics
                    double totalPayroll = hr.totalPayroll() + it.totalPayroll() + sales.totalPayroll();
                    Employee highest = null;
                    Department[] allDepts = {hr, it, sales};
                    for (Department d : allDepts) {
                        Employee h = d.highestPaid();
                        if (h != null && (highest == null || h.getSalary() > highest.getSalary())) {
                            highest = h;
                        }
                    }
                    System.out.println("\n=== Company Statistics ===");
                    System.out.println("Total Employees: " + Employee.getTotalEmployees());
                    System.out.println("Total Payroll: $" + totalPayroll);
                    if (highest != null) {
                        System.out.print("Highest Paid Employee Overall: ");
                        highest.displayEmployee();
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();

        
    }
}
