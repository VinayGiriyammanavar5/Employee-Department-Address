import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class representing an address
class Address {
    private String state;
    private String District;
    private String Street;

    // Constructor for creating an Address object
    public Address(String state, String District, String Street) {
        this.state = state;
        this.District = District;
        this.Street = Street;
    }

    // Override toString method to provide a string representation of the address
    @Override
    public String toString() {
        return state + ", " + District + ", " + Street;
    }
}

// Class representing a department
class Department {
    private String name;
    private String location;

    // Constructor for creating a Department object
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Override toString method to provide a string representation of the department
    @Override
    public String toString() {
        return name + " - " + location;
    }
}

// Class representing an employee
class Employee {
    private static int nextId = 1;

    private int id;
    private String name;
    private Address address;
    private Department department;

    // Constructor for creating an Employee object
    public Employee(String name, Address address, Department department) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
        this.department = department;
    }

    // Getter method for retrieving the employee ID
    public int getId() {
        return id;
    }

    // Getter method for retrieving the employee name
    public String getName() {
        return name;
    }

    // Getter method for retrieving the employee address
    public Address getAddress() {
        return address;
    }

    // Getter method for retrieving the employee department
    public Department getDepartment() {
        return department;
    }

    // Method for updating employee information
    public void updateEmployee(String newName, Address newAddress, Department newDepartment) {
        this.name = newName;
        this.address = newAddress;
        this.department = newDepartment;
    }

    // Override toString method to provide a string representation of the employee
    @Override
    public String toString() {
        return "Employee ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nDepartment: " + department;
    }
}

// Class containing CRUD (Create, Read, Update, Delete) operations for employees
class CRUDOperations {
    private Map<Integer, Employee> employees = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Method for creating a new employee
    public void createEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter District: ");
        String District = scanner.nextLine();
        System.out.print("Enter Street: ");
        String Street = scanner.nextLine();
        Address address = new Address(state, District, Street);

        System.out.print("Enter department name: ");
        String departmentName = scanner.nextLine();
        System.out.print("Enter department location: ");
        String departmentLocation = scanner.nextLine();
        Department department = new Department(departmentName, departmentLocation);

        Employee employee = new Employee(name, address, department);
        employees.put(employee.getId(), employee);
        System.out.println("Employee created:\n" + employee);
    }

    // Method for viewing all employee data
    public void viewData() {
        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
        } else {
            System.out.println("Employee Data:");
            for (Employee employee : employees.values()) {
                System.out.println(employee);
                System.out.println("----------");
            }
        }
    }

    // Method for reading employee data based on ID
    public void readEmployee() {
        System.out.print("Enter employee ID to read: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            System.out.println("Employee found:\n" + employee);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    // Method for updating employee data based on ID
    public void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Employee employee = employees.get(employeeId);
        if (employee != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new state: ");
            String newState = scanner.nextLine();
            System.out.print("Enter new District: ");
            String newDistrict = scanner.nextLine();
            System.out.print("Enter new Street: ");
            String newStreet = scanner.nextLine();
            Address newAddress = new Address(newState, newDistrict, newStreet);

            System.out.print("Enter new department name: ");
            String newDepartmentName = scanner.nextLine();
            System.out.print("Enter new department location: ");
            String newDepartmentLocation = scanner.nextLine();
            Department newDepartment = new Department(newDepartmentName, newDepartmentLocation);

            employee.updateEmployee(newName, newAddress, newDepartment);
            System.out.println("Employee updated:\n" + employee);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    // Method for deleting an employee based on ID
    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Employee employee = employees.remove(employeeId);
        if (employee != null) {
            System.out.println("Employee deleted:\n" + employee);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }
}

// Main application class
public class EmployeeData {
    public static void main(String[] args) {
        CRUDOperations crudOperations = new CRUDOperations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View Data");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    crudOperations.createEmployee();
                    break;
                case 2:
                    crudOperations.readEmployee();
                    break;
                case 3:
                    crudOperations.updateEmployee();
                    break;
                case 4:
                    crudOperations.deleteEmployee();
                    break;
                case 5:
                    crudOperations.viewData();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    scanner.close();
            }
        }
    }
}
