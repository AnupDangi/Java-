import java.util.*;
public class Vowels {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
        System.out.println("\n 1.Check Vowels \n 2.Exit \nEnter your choice:");
        int a=sc.nextInt();
        switch (a) {
            case 1:
                System.out.println("Enter a character ");
             char alphabets=sc.next().charAt(0);
        switch (alphabets) {
            case 'a':
            System.out.println("Vowel");
                break;
               case 'e':
            System.out.println("Vowel");
                break;
            case 'i':
            System.out.println("Vowel");
                break;
            case 'o':
            System.out.println("Vowel");
                break;
                 case 'u':
            System.out.println("Vowel");
                break;
            default: System.out.println("Consonants");
                break;
        }
         break;
        case 2: System.exit(0);
         break;
         default: System.out.println("Enter valid choice ");
         break;
    }
}
}
}
