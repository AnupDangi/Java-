public class MajorityEle {

    //brute force
    public static int majorityEle(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
        for(int j=0;j<arr.length;j++){
            if(arr[i]==arr[j]){
                count++;
            }
        }
        if(count>arr.length/2){
            max=arr[i];
        }
    }
        return max;

    }

    public static int optimalmajEle(int arr[]){
        int count=0;
        int ele=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(ele==arr[i]){
                count++;
            }
            else if(count==0){
                ele=arr[i];
                count=1;
            }
            else{
                count--;
            }
        }
        int count1=0;
        int maj=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                count1++;
            }
            if(count1>arr.length/2){
                maj=arr[i];
            }
        }
        return maj; 
    }
    public static void main(String[]args){
        int arr[]={1,2,1,1,2,2,2};
        System.out.println(optimalmajEle(arr));
        // int maxEle=majorityEle(arr);
        // System.out.println(maxEle);
    }
}
