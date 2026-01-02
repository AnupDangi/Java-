import java.util.*;
public class TreeSetImp {
    
    public static void main(String[] args) {
        //sorted in ascending order
        TreeSet<String> tset=new TreeSet<>();
        tset.add("Delhi");
        tset.add("China");
        tset.add("Noida");
        tset.add("Nepal");

        //Iteration on TreeSet
        Iterator itr=tset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
        }

        // int count=0;
        // while (!tset.isEmpty()) {
        //     count++;
        //     tset.removeFirst();
        // }
        // System.out.println(count);
        System.out.println(tset);
    }
}
