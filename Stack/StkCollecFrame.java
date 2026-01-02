import java.util.Stack;
public class StkCollecFrame {


    public static void pushAtBottom(Stack<Integer>s,int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        //store the top by removing it
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
        // s.toArray();
        //     // while(!s.isEmpty())
        //     // {
        //     //     System.out.println(s.peek());
        //     //     s.pop();
        //     // }

        //     //Push an element at the last of the stack using another stack
        //     s2.addAll(s); //creates a deep copy of all the elements
        //     s.removeAllElements();
        //     System.out.println(s);
        //     s.add(4);
        //     s.addAll(s2);
        //     System.out.println(s);
        //     //Though this is easy but consumes more extra spaces
            
        }
}

