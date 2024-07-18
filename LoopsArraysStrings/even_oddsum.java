import java.util.*;
public class Even_oddsum {
    public static void main(String args[])
    {
        System.out.println("Enter the number of terms ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int sum_even=0;
        int sum_odd=0;
        for(int i=1;i<=num;i++)
        {
            if(i%2==0)
            {
                System.out.print("Even numbers are"+i);
                sum_even=sum_even+i;
            }
        }
             for(int i=1;i<=num;i++){
            if(i%2!=0)
            {
                System.out.print("odd is "+i);
                sum_odd=sum_odd+i;
            }
        }
        System.out.println("sum of even is"+sum_even);
        System.out.println("sum of odd is"+sum_odd);
    }
}
