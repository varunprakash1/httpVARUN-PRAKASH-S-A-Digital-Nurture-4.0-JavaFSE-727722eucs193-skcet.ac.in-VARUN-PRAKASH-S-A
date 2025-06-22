class Employee{
    int employeeId;
    String name;
    String position;
    double salary;
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " - " + name + " - " + position + " - Rs. " + salary;
    }

}

public class EmployeeManagementSystem {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void addEmployee(Employee e){
        if(count < MAX_EMPLOYEES){
            employees[count++] = e;
            System.out.println("Employee added Successfully.");
        }
        else{
            System.out.println("Employee list is full.");
        }
    }

    public static Employee searchEmployee(int id){
        for(int i=0;i<count;i++){
            if(employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    public static void displayEmployees(){
        if(count == 0){
            System.out.println("No employees present.");
        }
        else{
            for(int i=0;i<count;i++){
                System.out.println(employees[i]);
            }
        }
    }

    public static void deleteEmployee(int id){
        int index = -1;
        for(int i=0;i<count;i++){
            if(employees[i].employeeId == id){
                index = i;
                break;
            }
        }

        if(index != -1){
            for(int i=index;i<count;i++){
                employees[i] = employees[i+1];
            }
            employees[--count] = null;
            System.out.println("Employee deleted Successfully");
        }
        else{
            System.out.println("Employee not found");
        }
    }

    public static void main(String[] args) {
        System.out.println();
        addEmployee(new Employee(101, "Sam", "Manager", 70000));
        addEmployee(new Employee(102, "Vishwa", "Developer", 50000));
        addEmployee(new Employee(103, "Yoki", "HR", 45000));
        System.out.println();

        System.out.println("\nAll Employees:");
        displayEmployees();
        System.out.println();

        System.out.println("\nSearch for Employee ID 102:");
        Employee e = searchEmployee(102);
        if (e != null) System.out.println(e);
        else System.out.println("Employee not found.");
        System.out.println();

        System.out.println("\nDeleting Employee ID 102:");
        deleteEmployee(102);
        System.out.println();        

        displayEmployees();
        System.out.println();        
    }
}