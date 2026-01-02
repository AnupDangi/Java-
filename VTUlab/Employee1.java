package labprog;

public class Employee1 {
	 private int id;
	 private String name;
	 private double salary;
	 public Employee1(int id, String name, double salary) {
	 this.id = id;
	 this.name = name;
	 this.salary = salary;
	 }
	 public void raiseSalary(double percent) {
	 double raiseAmount = salary * (percent / 100);
	 salary += raiseAmount;
	 }
	 public void displayEmployeeDetails() {
	 System.out.println("Employee ID: " + id);
	 System.out.println("Employee Name: " + name);
	 System.out.println("Employee Salary: $" + salary);
	 }
	//Main class
	 public static void main(String[] args) {
	 // Create an Employee object
	 Employee1 employee = new Employee1(101, "John Doe", 50000.0);
	 // Display the initial employee details
	 System.out.println("Initial Employee Details:");
	 employee.displayEmployeeDetails();
	 // Raise the salary by 10%
	 employee.raiseSalary(10);
	 // Display the updated employee details
	 System.out.println("\nEmployee Details After Salary Raise:");
	 employee.displayEmployeeDetails();
	 }
}

