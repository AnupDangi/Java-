import java.util.Scanner;

public class Even_odd {
    public static void main(String[] args) {
        System.out.println("Enter a number to check even or odd ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num%2==0)
        {
            System.out.println(num+"is even");
        }
        else{
            System.out.println(num+"is odd");
        }
    }
}
