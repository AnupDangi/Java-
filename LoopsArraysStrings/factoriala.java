import java.util.*;
public class factoriala {
    public static void main(String[] args)
    {
        int fact=1;
        int num;
        System.out.println("Enter a number ");
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        for( int i=1;i<=num;i++)
        {
            fact=fact*i;
        }
        System.out.print(fact);
    }
}
