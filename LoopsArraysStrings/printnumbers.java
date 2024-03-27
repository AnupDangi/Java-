import java.util.*;
public class Printnumbers {
        public static void main(String args[])
        {
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
                int counter=1;
                System.out.println("The numbers are ");
                while(counter<=num)
                {
                    System.out.print(" "+counter);
                    counter++;
                }
        }
    
}
