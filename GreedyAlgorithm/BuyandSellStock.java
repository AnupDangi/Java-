public class BuyandSellStock {
    
    public static int BuySellStock(int prices[]){
       
        int min_buy_value=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(min_buy_value>prices[i]){
                min_buy_value=prices[i];
            }
            if(prices[i]-min_buy_value>profit){
                profit=prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int prices[]={7,8,4,3,1};
        int profitday=BuySellStock(prices);
        System.out.println(profitday);
    }
}
