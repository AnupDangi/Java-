// import java.util.Collections;
// import java.util.ArrayList;
import java.util.*;
public class Practice2dArrayList {
    
    public static void main(String[]args)
    {
        //create three list 1 ,list2 and list3 
        //add the elements and print through traversing

        //Creating a 2d arraylist
        ArrayList <ArrayList<Integer>> mainlist=new ArrayList<>();

        //create first arraylist object
        ArrayList <Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        //now add the list1 to mainlist
        mainlist.add(list1);

            //create the object for list2 and add all the elements
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        //add the list to mainlist
        mainlist.add(list2);
        
        //same do for the list3

        ArrayList <Integer> list3=new ArrayList<>();
        list3.add(3);
        list3.add(6);
        list3.add(9);
        list3.add(12);
        list3.add(15);

        mainlist.add(list3);

        // now traversing through all the list and printing
        for(int i=0;i<mainlist.size();i++)
        {
            ArrayList<Integer> currlist=mainlist.get(i);

            for(int j=0;j<currlist.size();j++)
            {
                System.out.print(currlist.get(j)+" ");
            }
            System.out.println();
        }

        //just print the mainlist
        System.out.println(mainlist);
        //Now we can add all the elements inside the Arraylist at once

        ArrayList<Integer> addonce=new ArrayList<>();
        addonce.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(addonce);
    }

}
