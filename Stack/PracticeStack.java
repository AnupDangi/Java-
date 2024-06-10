import java.util.*;
public class PracticeStack {
    static class Node
    {
        int data;
        Node next;

     Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
    public static boolean ispalinLL(Node head)
    {
        Node slow=head;
        Stack<Integer> s=new Stack<>();
        boolean ispalin=true;
     
        while(slow!=null)
        {
            s.push(slow.data);
            slow=slow.next;
        }
        
        while(head!=null)
        {
            int i=s.pop();
            if(head.data==i)
            {
                ispalin=true;
            }
            else{
                ispalin=false;
                break;
            }
            head=head.next;
        }
        return ispalin;
    }
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(result);
                result = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(result);
                }
                result = temp.toString();
                index++;
                
            } else {
                result += s.charAt(index);
                index++;
            }
        }

        return result;
    }
    public static int trapmaxwater(int arr[]) //0(n)
    {
        int trappedwater=0;
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty() && arr[i]>arr[s.peek()]) //peek top
            {
                int pop_height=arr[s.pop()];
                if(s.isEmpty())
                {
                        break;
                }
                int distance=i-s.peek()-1;
                int min_height=Math.min(arr[s.peek()],arr[i])-pop_height;
                trappedwater+=distance*min_height;
             }
            s.push(i);
        }
        return trappedwater;
    }
    public static void main(String[] args) {
        Node one =new Node(1);
        Node two=new Node(2);
        Node three=new Node(3);
        Node four=new Node(2);

        //shortcut write 

        four.next=new Node(1);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next.next=null;

        //palindrome linked list using stack
            System.out.println(ispalinLL(one));
            String str="3[b2[v]]";  //"2[cv]"
            String ans= decodeString(str);
            System.out.println(ans);

            int heightarr[]={7,0,4,2,5,0,6,4,0,5};
           int maxwater= trapmaxwater(heightarr);
           System.out.println(maxwater);
        }
}
