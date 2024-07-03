import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  //Scanner class 
        System.out.println("Enter the two numbers: ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Sum is : "+(a+b));
        // Single line comments
        /* Multi line comments */
        sc.close();
}
}