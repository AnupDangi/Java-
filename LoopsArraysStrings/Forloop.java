import java.util.*;
public class Forloop {
    public static void main(String args[])
    {
        int num;
        System.out.println("Enter a number to find multiplication table of");
        Scanner sc=new Scanner(System.in);
         num=sc.nextInt();
        for(int i=1;i<=10;i++)
        {
            System.out.println(num+"*"+i+"="+i*num);
        }
    }
}
