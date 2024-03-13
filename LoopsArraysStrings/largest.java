import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        System.out.println("Enter two values for comparison of greatest ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(a>b)
        {
            System.out.println(a+"is greatest");
        }
        else{
            System.out.println(b+"is greatest");
        }
    }
}
