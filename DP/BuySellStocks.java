import java.util.*;
public class BuySellStocks {
    
    //brute force

    // public static int maxProfit(int arr[]){
    //     int profit=0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i;j<arr.length;j++){
    //                 profit=Math.max(profit, arr[j]-arr[i]);
    //             }
    //         }
    //     return profit;
    // }
 
    //optimized 0(n) and 0(1) space
    public static int maxProfitOptimized(int arr[]){
           int buystock=arr[0];

           int profit=0;
            for(int i=1;i<arr.length;i++){
                if(buystock>arr[i]){
                    buystock=arr[i];
                }

                if(arr[i]-buystock>profit){
                    profit=arr[i]-buystock;
                }
            }
            return profit;
    }

    //buy and sell stocks multiple times to maximize the profit
    public static int maximizeProfit(int arr[],int fee){
        int profit=0;
        int n=arr.length;
        int effectivebuyPrice=arr[0];
        for(int i=1;i<n;i++){
            profit=Math.max(profit, arr[i]-effectivebuyPrice-fee);
            //effectivebuy price is minimum as it should be the price to be bought everytime so update the new minimum if available
            effectivebuyPrice=Math.min(effectivebuyPrice, arr[i]-profit);
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int arr[]={6,1,7,2,8,4};
        int fee=2;
        //System.out.println(maxProfit(arr));
        System.out.println(maxProfitOptimized(arr));
        System.out.println(maximizeProfit(arr,fee));
    }
}
