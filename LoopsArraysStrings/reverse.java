import java.util.*;
public class Reverse {
    public static void main(String args[])
    {
        int num;
        int digit;
        int reverse=0;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        while(num>0)
        {
            digit=num%10;
            num/=10;
            System.out.print(digit);
        }
    }
}
