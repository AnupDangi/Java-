public class TargetSum {

    public static boolean checkTargetSum(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];

        //i=items & j=target sum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        //dp[i][j] refers to the no i item with cost j each cell contains the no of itemswith its respective weight j. 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v=arr[i-1]; //get the element weight  
                //include compare the weight with max weight and then check for true or false
                if(v<=j &&dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nums[]={4,2,7,1,3};
        int TargetSum=10;
        System.out.println("The sum of the target is matched:"+checkTargetSum(nums,TargetSum));

    }

}