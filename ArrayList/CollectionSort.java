import java.util.ArrayList;
import java.util.Collections;
  
public class CollectionSort {
    
    public static void main(String[] args) {
        ArrayList<Integer> arrlist=new ArrayList<>();
        arrlist.add(4);
        arrlist.add(5);
        arrlist.add(6);
        arrlist.add(1);
        arrlist.add(2);
        System.out.println("Before Sorting: "+arrlist);
        Collections.sort(arrlist);
        System.out.println("After Sorting: "+arrlist);
        //descending order sorting
        Collections.sort(arrlist,Collections.reverseOrder());
        //Comparators Collections.reverseOrder()is a used in function logic 
        
        System.out.println("Descending order Sorting: "+arrlist);

    }
}
