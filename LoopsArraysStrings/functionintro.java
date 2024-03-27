import java.util.Scanner;

public class Functionintro {
//    public static int printhelloWorld()//Creating a function
//    {
//         System.out.println("Hello World");
//         System.out.println("Hello World");
//         return 0;
//    }
//     public static void main(String[] args) {
//         printhelloWorld(); //function call
//     }
// }

// Function with input and sum of two number

//Sum function /Methods
public static void sum(int a,int b)//formal parameters or paramters
//Passing arguments
 {
    int sum=a+b;
    System.out.println(sum);
} 
public static int sum()//Without passing arguments
{
    int a,b;
    Scanner sc=new Scanner(System.in);
    a=sc.nextInt();
    b=sc.nextInt();
    int sum=a+b;
    System.out.println("sum is"+sum);
    return 0;
}
public static void main(String[] args) {
    //sum(2,4);//arguments or actual paramteres where exact value is passed
    //main function call should pass arguments if arguments are passed in function 
    sum();//Main function should not also pass arguments 
}
}