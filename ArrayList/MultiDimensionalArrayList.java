import java.util.ArrayList;
import java.util.Collections;
public class MultiDimensionalArrayList {
    
    public static void main(String[] args) {
        
        // syntax for 2d arraylist
        ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
        //first create object for list1 
        //Then add all the element inside its reference object and pass the object ref var to another 
        // main Arraylist object
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(9);
        list1.add(6);
        list1.add(8);
        list1.add(10);
        mainlist.add(list1);

        // Create the object for another Arraylist
        //add all the elements then pass the arraylist ref var to primary arraylist
        ArrayList<Integer>list2=new ArrayList<>();
        list2.add(8);
        list2.add(6);
        list2.add(5);
        list2.add(9);
        mainlist.add(list2);

        for(int i=0;i<mainlist.size();i++)
        {
            //Create the current arrlist and assign it to first arraylist of mainlist

            ArrayList<Integer> currlist=mainlist.get(i);
            //Then traverse through the currentlistof size then print all the elements
            for(int j=0;j<currlist.size();j++)
            {
                System.out.print(currlist.get(j)+" ");
            }
            System.out.println("");
        }
        System.out.println(mainlist);
    }
}
