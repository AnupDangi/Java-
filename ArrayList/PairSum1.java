import java.util.*;
public class PairSum1 {
    
    // Find the pairs for which sorted arraylist has a target sum 
    // Using basic brute force approach
    // O(n^2)
    public static int pairSum1(ArrayList<Integer> list,int target)
    {
        System.out.println();

        for( int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                if(target== list.get(i)+list.get(j))
                {
                    System.out.print(list.get(i)+","+list.get(j)+" ");
                }
            }
        }
        return 0;
    }
    public static void main(String[]args)
    {
       //ArrayList
       ArrayList <Integer> list=new ArrayList<>();
       //adding all at once 
       list.addAll(Arrays.asList(1,2,3,4,5,6));        
        int target=50;
        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                //remember in arraylist we use .get() method to access any index value
                if(target==list.get(i)+list.get(j))
                {
                    System.out.print(list.get(i)+","+list.get(j)+" ");
                }
            }
        }
        pairSum1(list,target);
    }
}
