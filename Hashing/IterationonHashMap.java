import java.util.*;
public class IterationonHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hmap =new HashMap<>();

        //insert
        hmap.put("India", 100);
        hmap.put("China", 120);
        hmap.put("Nepal", 99);
        hmap.put("US", 160);

        //Iterate over keys pass keys types in set
        //print keys of set from hasmap this is unordered dataset maybe randomly stored
        Set<String> keys=hmap.keySet();
        System.out.println(keys);

        for (String k: keys) {
            System.out.println("key="+k+ ","+"value="+hmap.get(k));
        }

    }
}
