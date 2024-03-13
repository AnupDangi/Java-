import java.util.Scanner;

public class breakcase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Enter your number");
            int num=sc.nextInt();
            if(num%10==0)
            {
                continue;
            }
           else 
            {
                System.out.print(num);
            }

        }
    }
}
