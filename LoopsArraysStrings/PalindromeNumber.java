import java.util.*;
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to check palindrome or not:");
        int num= sc.nextInt();
        int digit;
        int revnum=0;
        int reverse=num;
        while (num>0){
            digit=num%10;
            revnum=revnum*10+digit;
            num/=10;
        }
       // System.out.println(revnum);
        if (reverse==revnum) {
            System.out.println(reverse+" is a palindrome");
        }
        else{
            System.out.println(reverse+" is not a palindrome");
        }
    }
}
