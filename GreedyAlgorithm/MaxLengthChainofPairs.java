import java.util.Arrays;
import java.util.*;
public class MaxLengthChainofPairs {
 
    public static void main(String[]args){
        /*Algorithm
        1.Sort pairs (Based on second number)
        2. 1st pair 
        if (pair->start>=lastselected->end)
         * 
         */ 
        //0(nlogn)

        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

         Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        
         int chainLen=1;
         int chainEnd=pairs[0][1];
         for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>=chainEnd){
                chainLen++;
                chainLen=pairs[i][1];
            }
         }

         System.out.println("Max lendth of chain="+chainLen);
    }
}
