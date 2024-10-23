
import java.util.*;

public class HashMapImp{
    //HashMap are unordered datastructure 

    public static void main(String[] args) {
        //create 
        HashMap<String,Integer> hmap=new HashMap<>();

        //insert -0(1)
        hmap.put("Nepal",20);
        hmap.put("India",30);
        System.out.println(hmap);

        //get 0(1)
        int popul=hmap.get("Nepal");
        System.out.println(popul);

        //get error as the value doesnot exists

        // int getpopul=hmap.get("China");
        // System.out.println(getpopul);

        //contains key
        System.out.println(hmap.containsKey("Nepal"));
        System.out.println(hmap.containsKey("China"));


        //remove operation 0(1) deletes and gives the value
        System.out.println(hmap.remove("India"));
        System.out.println(hmap.remove("China"));

        System.out.println(hmap.containsKey("India"));
        System.out.println(hmap);

        //get size
        System.out.println(hmap.size());

        //isEmpty
        System.out.println(hmap.isEmpty());


        //clear all elements
        hmap.clear();

        //check for empty
        System.out.println(hmap.isEmpty());

        
    }
}
