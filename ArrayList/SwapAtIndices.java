import java.util.ArrayList;
public class SwapAtIndices {
    public static void swap(ArrayList<Integer>arrlist, int indx1,int indx2)
    {
        //use of get and set methods 
        //to get index use .get(index)
        //to set value use .set(index,list.get(index));
        int temp=arrlist.get(indx1);
        arrlist.set(indx1,arrlist.get(indx2));
        arrlist.set(indx2,temp);
    }
    public static void main(String[]args)
    {
        ArrayList <Integer> arrlist =new ArrayList<>();
        arrlist.add(2);
        arrlist.add(5);     //1
        arrlist.add(9);
        arrlist.add(3);      //3 
        arrlist.add(6);

        // swap the numbers at given indices ie ie id:1 and id 3
        int indx1=1,indx2=3;
        System.out.print(arrlist);
        swap(arrlist,indx1,indx2);
        System.out.println();
        System.out.print(arrlist);
    }
}
