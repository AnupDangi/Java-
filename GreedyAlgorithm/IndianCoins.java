import java.util.Comparator;
import java.util.*;
public class IndianCoins {
    
    public static void main(String[]args){
        /* Algorithm
        1.Sort Descending[50,10,2,1] --eg
        amount=given value
        2.check if (coin[i]<amount)
        3.while(coin[i]<amount){
            count++
            amount=amount-coin[i]
        }
         * 
         */

        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        ArrayList<Integer> ans=new ArrayList<>();
        
        int countofCoins=0;
        int amount=590;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countofCoins++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                }
            }
        }
        System.out.println("Total Minimum number of coins: "+countofCoins);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
