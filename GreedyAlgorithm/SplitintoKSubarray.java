public class SplitintoKSubarray {
    


    public static int splitarray(int arr[],int k){
        int left=0,right=0;
        for(int i=0;i<arr.length;i++){
            left=Math.max(left,arr[i]);
            right+=arr[i];
        }
        while(left<right){
            int mid=(left+right)/2;
            if(canSplit(arr,k,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean canSplit(int arr[],int k,int maxSum){
        int currentSum=0;
        int splits=1;
        for(int i=0;i<arr.length;i++){
            if(currentSum+arr[i]>maxSum){
                currentSum=arr[i];
                splits++;
                if(splits>k){
                    return false;
                }
            }
            else{
                currentSum+=arr[i];
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,3,2};
        int k=2;
        //Output:2
        //we need to find the minimum of all max subarray sub divided into k paritions
        System.out.println(splitarray(arr,k));
    }
}
