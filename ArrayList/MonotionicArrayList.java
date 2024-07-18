import java.util.Arrays;
import java.util.ArrayList;
public class MonotionicArrayList {
    

    public static boolean checkMonotone(ArrayList<Integer> list)
    {
        boolean incvalue=false;
        boolean decvalue=false;
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)<=list.get(i+1))
            {
                incvalue=true;
            }
            if(list.get(i)>=list.get(i+1))
            {
                decvalue=true;
            }
            else
            {
                return false;
            }   
        }
        
        return true;
    }
    public static void main(String[]args)
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(1,3,2));
        System.out.print(checkMonotone(list));
    }
}
