import java.util.*;
public class TreeMapImp {
    
    public static void main(String[] args) {
        TreeMap<String,Integer> tmap=new TreeMap<>();
        tmap.put("US",50);
        tmap.put("China",10);
        tmap.put("India", 99);
        tmap.put("Nepal",99);

        //gives output in sorted order of keys 
        System.out.println(tmap);
    }
}
