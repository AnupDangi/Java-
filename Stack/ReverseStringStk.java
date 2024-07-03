import java.util.Stack;

public class ReverseStringStk {
    
    public static String reverse(String str)
    {
        //Implement Character stack
        Stack<Character> s=new Stack<>();
        int index=0;
        //till the end of str length  push the each character onto stack
         while(index<str.length())
         {
            s.push(str.charAt(index));
            index++; //increment the stack
         }
         StringBuilder result=new StringBuilder("");
         //one of good mutable string type ie stringbuilder to manipulate the string
         //builder is used in critical environment when performance is critical or single threaded environment
         while(!s.isEmpty())
         {
            char top=s.pop();
            result.append(top);
            index++;
         }
         return result.toString();
    }


    public static void main(String[] args) {
       String str="abc";
        String result= reverse(str);
        System.out.println(result);
    }
}
