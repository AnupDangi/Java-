import java.util.HashMap;
import java.util.Set;

public class MajorityElement { //0(N)
    
    public static void main(String[] args) {
        int nums[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hmap=new HashMap<>();
        
        //traverse over array  and store the frequency and element inside map
        for(int i=0;i<nums.length;i++){

            //check if key already exists or not 

            // if(hmap.containsKey(nums[i])){
            //     hmap.put(nums[i],hmap.get(nums[i])+1);
            // }
            // else{
            //     hmap.put(nums[i], 1);
            // }
            // This is short handed method to get value everytime either it exists or not 
            hmap.put(nums[i],hmap.getOrDefault(nums[i], 0)+1);
        }
        //To iterate over map use Set use keys as datatype
        //short handed 
        //Set<Integer> keySet=hmap.keySet();

        for(Integer key:hmap.keySet()){
            if(hmap.get(key)>nums.length/3){
                System.out.println(hmap.get(key));
            }
        }

    }
}
