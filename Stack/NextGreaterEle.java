import java.util.Stack;
public class NextGreaterEle {

    public static int[] findnextgreater(int arr[])
    {
        int nextgreater[]=new int[arr.length];
        Stack <Integer>s=new Stack<>();
        //using a loop
        
        for(int i=arr.length-1;i>=0;i--)
        {
            //step 1 if the stack top is less than arr[i] then pop 
            while(!s.isEmpty() &&arr[s.peek()]<=arr[i])
            {
                    s.pop();
            }
            //step 2  isempty that means no elements are greater than arr[i]
            if(s.isEmpty()){
                nextgreater[i]=-1;
            }
            //step3 
            else{
                nextgreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        return nextgreater;
    }
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int outarr[]=findnextgreater(arr);
        for(int i=0;i<outarr.length;i++) 
        {
            System.out.print(outarr[i]+" ");
        }
        
        //next greater right
        //next greater left side --reverse the loop
        //next smaller in right side  --change the while loop condition
        //next smaller in left side   --reverse the loop
    }
}
