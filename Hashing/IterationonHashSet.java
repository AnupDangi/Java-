import java.util.*;
public class IterationonHashSet {
    
    public static void main(String[] args) {
        HashSet<String> hset=new HashSet<>();
        
        //add int hashset
        hset.add("Gudgaun");
        hset.add("Delhi");
        hset.add("Noida");
        hset.add("Bangalore");

        //use of iteratiors

        // Iterator itr=hset.iterator();
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        //advanced for loop 
        for(String city: hset){
            System.out.println(city);
        }
    }
}
