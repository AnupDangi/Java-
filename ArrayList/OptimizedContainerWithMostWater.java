// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Arrays;
import java.util.*;
public class OptimizedContainerWithMostWater {
    
    // Optimized approach for Container with Most Water using two pointers

    public static int storeWater(ArrayList<Integer> height)
    {
            int maxwater=0;
            //use a loop and two pointers to track the largest height till now
            // initialize two pointers one from start and another from end
            int leftptr=0;
            int rightptr=height.size()-1;
            for(int i=0;i<height.size();i++)
            {
                while(leftptr<rightptr)
                {
                     //calculate height and width
                     int ht=Math.min(height.get(leftptr),height.get(rightptr));
                     int width=rightptr-leftptr;
                     int currwater=ht*width;
                      // udpate ptr
                     maxwater=Math.max(maxwater,currwater);  
                     //remember only small pointer can hold the water
                     
                        if(leftptr<rightptr)
                        {
                            leftptr++;
                        }
                        else{
                            rightptr--;
                        }
                }
            }
            return maxwater;
    }
    public static void main(String[]args)
    {
        ArrayList <Integer> height=new ArrayList<>();
        
        //add all the elements at once
        height.addAll(Arrays.asList(1,8,6,2,5,4,8,3,7));
        System.out.println(storeWater(height));
    }
}
