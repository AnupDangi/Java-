import java.util.*;
public class characterpattern {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //char ch='a'//'A';//
        char ch=sc.nextLine().charAt(0);
        int num=sc.nextInt();
       /*  for(int i=1;i<=num;i++)
        {
            for(int chars=1;chars<=i;chars++)
            {
                System.out.print(ch);
                ch++;
            }
            System.out.println(" ");
            
        }*/
            // for dry run understand
            // take input of character ='A'
            //increment it after printing then it will print 'B'
        for(int i=1;i<num;i++)
        {
            for(int chars=num;chars>=i;chars--)
            {
                System.out.print(ch);
                ch++;
            }
            System.out.println(" ");
        }
    }
}
