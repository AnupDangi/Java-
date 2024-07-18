
import java.util.*;

/**
 * This class generates letter combinations based on input digits.
 */
public class LetterCombination {
    
    /**
     * The character arrays representing letters associated with digits.
     * Index 0 and 1 are empty as they are not associated with any letters.
     * Index 2 to 9 correspond to digits 2 to 9 on a phone keypad.
     */
    final static char[][] L = {
        {}, {}, // Digits 0 and 1 have no associated letters
        {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
        {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    /**
     * Generates and prints letter combinations for a given digit string.
     * @param D The digit string for which letter combinations are generated.
     */
    public static void letterCombination(String D){
        int len = D.length();
        if(len == 0)
        {
            System.out.print(" "); // Print space for empty input
            return;
        }
        bfs(0, len, new StringBuilder(), D);
    }

    /**
     * Recursive method to generate letter combinations.
     * @param pos The current position in the digit string.
     * @param len The length of the digit string.
     * @param sb The StringBuilder to build letter combinations.
     * @param D The digit string.
     */
    public static void bfs(int pos, int len, StringBuilder sb, String D) {
        if(pos == len) {
            System.out.print(sb.toString() + ","); // Print the generated combination
        } else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for(int i = 0; i < letters.length; i++) {
                bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), D);
            }
        }
    }

    /**
     * Main method to test the letterCombination method.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        letterCombination("23"); // Test with input digit string "2"
    }
}


// import java.util.*;
// public class LetterCombination {
    
//     final static char [][] L={ { },{},
//                                 {'a','b','c'},{'d','e','f'},{'g','h','i'},
//                                 {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
//                                 {'t','u','v'},{'w','x','y','z'}};

//     public static void letterCombination(String D){
//         int len=D.length();
//         if(len==0)
//         {
//             System.out.print(" "+" ");
//             return;
//         }
//         bfs(0,len,new StringBuilder(),D);
//         }

//     public static void bfs(int pos, int len, StringBuilder sb, String D)
//     {
//         if(pos==len)
//         {
//             System.out.print(sb.toString()+",");
//         }
//         else
//         {
//             char [] letters=L[Character.getNumericValue(D.charAt(pos))];
//             for(int i=0;i<letters.length; i++)
//             {
//                 bfs(pos+1,len,new StringBuilder(sb).append(letters[i]),D);
//             }
//         }
//     }
//     public static void main(String[]args)
//     {
//         letterCombination("2");
//     }
    
// }