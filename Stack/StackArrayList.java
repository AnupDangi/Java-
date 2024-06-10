import java.util.ArrayList;
public class StackArrayList{
    public static class Stack{
       static  ArrayList<Integer>list=new ArrayList<>();
        public static boolean isEmpty()
        {
            return (list.size()==0);
        }
        public static int push(int data)
        {
            list.add(data);
            return data;
        }
        public static void pop()
        {
            if(list.size()==0)
            {
                return;
            }
            int removed=list.remove(list.size()-1);
            System.out.println("Popped element is "+removed);
        }
        public static int peek()
        {
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        
        Stack stk=new Stack();
        stk.push(2);
        stk.push(3);
        while(!stk.isEmpty())
        {
            System.out.println("The peeked element is "+stk.peek());
            stk.pop();
        }
    }
}