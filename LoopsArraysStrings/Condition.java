import java.util.Scanner;
public class Condition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int year=sc.nextInt();
        if (year>=18) {
            System.out.println("You are an adult ");
        }
        else{
            System.out.println("You are a teenager or a child");
        }
    }
}
