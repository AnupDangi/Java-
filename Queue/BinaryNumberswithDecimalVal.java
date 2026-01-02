import java.util.*;

public class BinaryNumberswithDecimalVal {
    
    //Generate N binary numbers from 1 to n 
    // if n is 5 print 1,10,11,100,101
    public static ArrayList<String>generateBin(int n){
       ArrayList<String> ans=new ArrayList<>();
       Queue<String> sq=new LinkedList<>();
       sq.add("1");
       while(n-->0){
            String s=sq.peek();
            ans.add(s);
            sq.add(s+"0");
            sq.add(s+"1");
            sq.remove();
      }
        return ans;       
    }
    public static void main(String[]args){

        ArrayList<String>ans=generateBin(10);
        System.out.println(ans);
    }
}
