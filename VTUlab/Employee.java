
package labprog;
import java.util.*;
public class Employee {
	private double salary(double percent,double salary) {
		if(percent>0)
		{
			salary=salary+(salary*(percent/100));	
		}
		else
		{
			System.out.println("Invalid percentage");
		}
		return salary;
	}
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Employee id");
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter Employee name");
	String name=sc.nextLine();
	System.out.print("Enter Salary of the Employee ");
	double salary=sc.nextDouble();
	
	//Object 
	Employee e1=new Employee();
	System.out.println("Enter the percentage rasise in salary");
	double percent=sc.nextDouble();
	double updatedsalary=e1.salary(percent, salary);
	System.out.println("\nEmployee Details after Raise");
	System.out.println("Employee Id:"+id);
	System.out.println("Employee Name: "+name);
	System.out.println("Employee Salary: "+updatedsalary);
}
}
