import java.util.*;
class Solution {
    public static boolean isValid(String s) {
     int n=s.length();
      Stack<Character> stk = new Stack<>();
     for (int i = 0; i < n; i++) {
         char c = s.charAt(i);
         // Push opening brackets onto the stack
         if (c == '(' || c == '[' || c == '{') {
             stk.push(c);
         } 
         
         // Check for closing brackets and matching with the top of the stack
         else if (c == ')' && !stk.isEmpty() && stk.peek() == '(') {
             stk.pop();
         } else if (c == '}' && !stk.isEmpty() && stk.peek() == '{') {
             stk.pop();
         } else if (c == ']' && !stk.isEmpty() && stk.peek() == '[') {
             stk.pop();
         } 
         else if(c==')'||c==']'||c=='}'){
            stk.push(c);
        }
     }
     return stk.isEmpty();
 }
 public static void main(String[] args) {
    String str="{{{}}";
    System.out.println(isValid(str));
 }
 }