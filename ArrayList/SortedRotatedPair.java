import java.util.*;
public class SortedRotatedPair {

    public static int PairSum2(ArrayList<Integer> list,int target)
    {
        // find breaking point at which the sorted array is partitioned
        int breakpt=-1;
        int n=list.size();
        for(int i=0;i<list.size();i++)
        {
            //breaking point where the partitioned between two sorted array is found
            if(list.get(i)>list.get(i+1))
            {   
                breakpt=i;
                break;
            }
        }
        // lptr must be breakpt+1 and rptr is breakpt
        int lptr=breakpt+1;
        int rptr=breakpt;
        while(lptr!=rptr)
        {
            if(list.get(lptr)+list.get(rptr)==target)
            {
                System.out.println(list.get(lptr)+","+list.get(rptr));
                return 0;
            }
            //case 1
            // if lptr+rptr gives < value then increment the lptr always because the rptr is mostly at the 
            // largest value 
            else if(list.get(lptr)+list.get(rptr)<target)
            {
                lptr=(lptr+1)%n; // n is defined above
            }
            //case 2
            else
            {
                // this is mathematical formulae for finding the next rptr so decrement it
                // if i dont recall this look back to the problem in copy and dry run
                //logic to find next rptr
                rptr=(n+rptr-1)%n;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(11,15,6,8,9,10));
        int target=16;
        PairSum2(list, target);
    }

}
