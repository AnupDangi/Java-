import java.util.*;
public class Input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       /*  String input =sc.next();
       
        int num=sc.nextInt();
        System.out.println("The number you entered is "+num);
        double dblNum=sc.nextDouble();
        System.out.println("The number you have entered is "+dblNum);
        String input1=sc.nextLine();//nextLine will print a text or paragraph
        System.out.println(input1);*/

        //Product of a and b
        System.out.println("Enter the value of a and b: ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int product=a*b;
        System.out.print("The product :"+product);
        sc.close();
}
}