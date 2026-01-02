
import java.util.*;


public class Palindrome {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for (char ch:str.toCharArray()) {
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }

        StringBuilder rev=new StringBuilder(sb.toString());
        rev.reverse();

        if(sb.toString().equals(rev.toString())){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
