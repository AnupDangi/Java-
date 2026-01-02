import java.util.ArrayList;
public class ReverseArrayList {
    public static void main(String[]args)
    {
        System.out.println("This is the reverse of an ArrayList");

        // Creating an arraylist
        ArrayList<Integer> arrlist=new ArrayList<>();
        arrlist.add(1);
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(5);

        //Reverse Print 
        //Remember to use to find length method as objname.size();
        // objname.get(index)
        // TC O(n)
        for(int i=arrlist.size()-1;i>=0;i--)
        {
            System.out.print(arrlist.get(i)+" ");
        }
        System.out.println();
    }
}
