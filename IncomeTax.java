import java.util.Scanner;

public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double income=sc.nextDouble();
        double tax;
        if (income<500000.0) {
            tax=0.0;
            System.out.println("Amount you need to pay to government is:"+tax);
        }
        else if (income>500000.0 || income<=1000000.0) {
            tax=(0.2)*income;
            System.out.println("Amount you need to pay to government is: "+tax);
        }
        else {
            tax=(0.3)*income;
            System.out.println("Amount you need to pay to government is :"+tax);
        }
    }
}
