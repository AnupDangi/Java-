import java.util.*;
public class ValidParanthesis {

    //Checks for valid parenthesis 
    //eg ({[]}) -True
    //eg ({[}) -False

    public static boolean isValid(String str)
    {
        Stack<Character>s=new Stack<>(); //0(n)
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            //pushing the opening bracket
            if(ch=='('||ch=='{'||ch=='[')
            {
                s.push(ch);
            }
            else{
                //closing
                if(s.isEmpty())
                {
                    return false;
                }
                    else if(s.peek()=='(' &&ch==')'       //pairs
                            || s.peek()=='{' &&ch=='}'
                            ||s.peek()=='['&&ch==']')
                    {
                            s.pop(); //pop the top if it matches everytime
                    }
                    else{
                        return false;
                    }
            }
        }
        if(s.isEmpty())
        {
            return true;
        }
        return false;
    }


    //duplicate parentesis 
    // eg ((a+b))-True
    //eg  (a-b) -False
    public static boolean isDuplicate(String str)
    {
        Stack <Character> s=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);

            if(ch==')')
            {
                int count=0;
                while(s.pop()!='(')
                {
                    count++;
                }
                if(count<1)
                {
                    return true;  //duplicate
                }
            }
               else{
                    //opening
                    s.push(ch);
                }
            }
            return false;
    }

    //Max area in a histogram
    //for this question sample input is array height ie
    //int arr[]={2,1,5,6,2,3};
    // output should be max area ie height into width 
    //Main concerned for this problem is to find the width 
    //Then its easy to calculate max among all of the area 

        //To calculate the area for each height use next Smaller on the right side and on left side
    public static void maxArea(int arr[]) //-O(n)  TC
    {
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        //next Smaller Right    -O(n)
        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=arr.length; //is it is empty then the size of n is the boundary that means
                                // no small element exist on the stack
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        //next Smaller Left   -O(n)
        s=new Stack<>();
        for(int i=0;i<arr.length;i++)  //calculate the left side smaller element
        {
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())

            {
                nsl[i]=-1; //no boundary max in left 
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //Current areare :width =j-i-1=nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++)
        {
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
             maxArea=Math.max(currArea,maxArea);
        }
        System.out.println("max area in histogram is "+maxArea);;
    }


    public static void main(String[] args) {
        //String str="({}[])";
        String str="((a+b))";
      // boolean ans= isValid(str);
        System.out.println(isDuplicate(str));
       // System.out.println(ans);
       int arr[]={2,1,5,6,2,3};
       maxArea(arr);
    }
}
