import java.util.*;
public class MostFreqNumber {
    
    public static int findfreqnum(ArrayList <Integer> list, int key)
    {
        int []result=new int[1000];

        // check the target frequency
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)==key)
            {
                // keep the element after the target
                result[list.get(i+1)-1]++;
            }
        }

        
        int max=Integer.MIN_VALUE;
        int ans=0;

        // check if the index contains more than one time check the frequency
        for(int i=0;i<result.length;i++)
        {
            if(result[i]>max)
            {
                max=result[i];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[]args)
    {
        ArrayList <Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(2,2,2,2,3));
        int key=2;
        System.out.print(findfreqnum(list, key));
    }
}

