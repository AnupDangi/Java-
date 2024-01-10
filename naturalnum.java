import java.util.Scanner;

public class naturalnum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=1;
        int num=sc.nextInt();
        int sum=0;
        while(i<=num)
        {
            sum+=i;
            System.out.println(i+"+"+(i-1)+"="+sum);
            i++;
        }

    }
}
