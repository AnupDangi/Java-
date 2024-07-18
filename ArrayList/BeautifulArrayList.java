import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class BeautifulArrayList {
    

    // This is the problem for beautiful array in which 
    // the combination of elements are in even , odd form which does not satifies
    // these property of arr[i]+arr[j]!=2*arr[k] ie between i<k<j

    public static ArrayList<Integer> beautifulArray(int num)
    {
       ArrayList <Integer> ans=new ArrayList<Integer>();
       ans.add(1);
       
       while(ans.size()<num)
        {
            ArrayList<Integer> temp=new ArrayList<Integer>();
            int ans_size=ans.size();
            for(int i=0;i<ans_size;i++)
            {
                // checks if the number is less than num and satisfies 2n-1 property of odd number
                if((ans.get(i)*2-1)<=num)
                {
                    // This is for gives odd number 
                    temp.add((ans.get(i)*2)-1);
                }
            }
            // this gives the even arr 2n <n property
                for(int i=0;i<ans_size;i++)
                {
                    if(ans.get(i)*2<=num)
                    {
                        temp.add(ans.get(i)*2);
                    }
                }
                ans=temp;
        }

        return ans;
    }
    public static void main(String[]args)
    {   
        // int num=sc.nextInt();
        Scanner sc=new Scanner(System.in);
        Integer num=sc.nextInt();
        ArrayList<Integer> ansarrlist=beautifulArray(num);
        for(int i=0;i<ansarrlist.size();i++)
        {
            System.out.print(ansarrlist.get(i)+" ");
        } 
    }
}
