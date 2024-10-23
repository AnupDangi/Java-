import java.util.*;
public class LinkedHashMapColl{
    
    public static void main(String[] args) {
        //Linked hashmap gives output based on insertion order.
        
        LinkedHashMap<String,Integer> lhmp=new LinkedHashMap<>();
        lhmp.put("India",99);
        lhmp.put("China",400);
        lhmp.put("Nepal", 33);
        System.out.println(lhmp);
        
        //Compare HashMap and LinkedHashMap
        HashMap<String,Integer> hmap=new HashMap<>();
        hmap.put("Nepal", 33);
        hmap.put("India", 333);
        hmap.put("US", 433);
        hmap.put("China", 333);

        System.out.println(hmap);

    }
}
