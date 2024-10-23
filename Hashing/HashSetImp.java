import java.util.*;
public class HashSetImp {
    
    //1. no duplicates
    //2.uses HashMap internally
    //3. null value is allowed
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(3);
        System.out.println(set);

        if(set.contains(2)){
            System.out.println("true");
        }
        set.remove(2);
        System.out.println(set);
        
        //size
        System.out.println(set.size());

        //clear or remove all elements
        set.clear();

        System.out.println(set);
        
    }
}
