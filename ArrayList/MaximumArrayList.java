import java.util.ArrayList;

public class MaximumArrayList {
    
    public static void main(String[]args)
    {
        ArrayList <Integer> arrlist=new ArrayList<>();
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(9);
        arrlist.add(8);

        int max=Integer.MIN_VALUE;
        //0(n)
        for(int i=0;i<arrlist.size();i++)
        {   
            // if(max<arrlist.get(i))
            // {
            //     max=arrlist.get(i);
            // }
            //another way to do is ie O(n)
            max=Math.max(max,arrlist.get(i));
        }
       
        
        System.out.print("Max element is my max "+max);
    }
}
