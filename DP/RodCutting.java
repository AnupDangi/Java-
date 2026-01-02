import java.util.*;
public class RodCutting {
    
    public static int rotCuttingWays(int length[],int price[],int rodlength){ //n*rodlength
        int n=length.length;

        //make a dp tabulation
        //intialize the values

        int dp[][]=new int[n+1][rodlength+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<rodlength+1;j++){
                if(i==0||j==0){
                    dp[i][0]=0;
    
                }
            }
        }

        //main logic
        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodlength+1;j++){

                //valid case
                if(length[i-1]<=j){//include  ,exclude max
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][rodlength];
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totallength=8;
        System.out.println(rotCuttingWays(length,price,totallength));

    }
}
