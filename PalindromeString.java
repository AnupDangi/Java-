import java.util.*;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String string=sc.nextLine();
        int length=string.length();
        int count=0;
        //Iterative Method
            for (int i = 0; i < length / 2; i++) {
                if (string.charAt(i) != string.charAt(length - 1 - i)) {
                    count=1;
                }
            }
                if (count ==1)
                {
                    System.out.println("This is not a palindrome String");
                }
                else{
                    System.out.println("This is a palindrome String");
                }
            //Comparing the indices

    //             boolean isPalindrome=true;
    //             int left=0;
    //             int right=string.length()-1;
    //         while (left < right) {
    //         if (string.charAt(left) != string.charAt(right)) {
    //             isPalindrome = false;
    //             break;
    //         }
    //         left++;
    //         right--;
    //     }
    //     if (isPalindrome) {
    //         System.out.println("Palindrome string");
    //     } else {
    //         System.out.println("Not a palindrome string");
    //     }
    // }
    }
}
