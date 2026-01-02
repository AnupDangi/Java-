import java.util.*;
public class OptimizedPairSum {

    public static int pairSum2(ArrayList<Integer> list, int target)
    {
        // intializing two pointers from front and rear
        int lptr=0;
        int rptr=list.size()-1;
        //O(n) because the while loop is taking the constant time for each of the opeartion inside
        // the main for loop where it just checks the ptr 
        for(int i=0;i<list.size();i++)
        {
            while(lptr<rptr)
            {
                //case 1 matches the target
                if(list.get(lptr)+list.get(rptr)==target)
                {
                    System.out.println(list.get(lptr)+","+list.get(rptr));
                    return 0;
                }
                //case 2 less than the target
                else if (list.get(lptr)+list.get(rptr)<target) {
                    lptr++;
                }
                else
                {
                    rptr--;
                }
            }
        }
        return 0;
    }
    public static void main(String[]args)
    {
        ArrayList <Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5));
        int target=5;
        pairSum2(list,target);
    }
}
