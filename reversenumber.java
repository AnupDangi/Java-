import java.util.*;
public class reversenumber {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int digit;
        int reverse=0;
        while(num>0)
        {
            digit=num%10;
            reverse=(reverse*10)+digit;
            num/=10;
        }
        System.out.print(reverse);
    }
}