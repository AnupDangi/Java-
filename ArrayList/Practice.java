import java.util.*;

public class Practice {

    public static void printarrayList(ArrayList<Integer> arrlist)
    {
        for(int i=0;i<arrlist.size();i++)
        {
            System.out.print(arrlist.get(i)+" ");
        }
        System.out.println("");
    }
    public static void bubbleSort(ArrayList<Integer>arrlist)
    {
        
        for(int i=0;i<arrlist.size()-1;i++)
        {
            for(int j=0;j<arrlist.size()-i-1;j++)
            {
                if(arrlist.get(j)>arrlist.get(j+1))
                {
                  int temp=arrlist.get(j);
                    arrlist.set(j,arrlist.get(j+1));
                    arrlist.set(j+1,temp);
                }
            }
        }
        printarrayList(arrlist);
    }
    public static void selectionSort(ArrayList<Integer> arrlist)
    {
        for(int i=0;i<arrlist.size()-1;i++)
        {
            int minipos=i;
            for(int j=i+1;j<arrlist.size();j++)
            {
                if(arrlist.get(j)<arrlist.get(minipos))
                {
                    minipos=j;
                }
            }
            int temp=arrlist.get(minipos);
            arrlist.set(minipos,arrlist.get(i));
            arrlist.set(i,temp);
        }
        printarrayList(arrlist);
    }
    public static void insertionSort(ArrayList<Integer>arrlist)
    {
        for(int i=1;i<arrlist.size();i++)
        {
            // get the current element 
            // get prev from i-1
            int current=arrlist.get(i);
            int prev=i-1;
            // until the prev comes to 0 th index and if current position value is less than prev

            while(prev>=0 && current<arrlist.get(prev))
            {
                // set the prev+1 value with prev 
                arrlist.set(prev+1,prev);
                prev--; // decrement of previous 
            }
            // set the prev with the current index
            arrlist.set(prev+1,current);
        }
        printarrayList(arrlist);
    }
    public static void main(String[]args)
    {
        ArrayList<Integer> arrlist=new ArrayList<>();
        arrlist.addAll(Arrays.asList(2,3,6,7,1));
        bubbleSort(arrlist);
        selectionSort(arrlist);
        insertionSort(arrlist);
    }
}
