import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
    // Given n lines on x axis ,use 2 lines to form a container such that it holds maximum of 
    //water

    // This is brute force approach is O(n^2)
    public static int storeWater(ArrayList<Integer> height)
    {
            int maxWater=0;
            //brute force approach 
            for(int i=0;i<height.size();i++)
            {
                for(int j=i+1;j<height.size();j++)
                {
                    int ht=Math.min(height.get(i),height.get(j));
                    int width=j-i;
                    int currWater=ht*width;
                    maxWater=Math.max(maxWater,currWater);
                }
            }
            return maxWater;
    }
    public static void main(String[]args)
    {
        ArrayList<Integer> height=new ArrayList<>();

        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // now this is the manual way of adding

        // Adding all atonce uses
        height.addAll(Arrays.asList(1,8,6,2,5,4,8,3,7));
        int storewater=storeWater(height);
        System.out.println(storewater);
    }
}
