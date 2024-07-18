public class InversionCount {
    //Problem statement
    //Given an array of integers. Find theInversion Countin the array
    // eg 
    /*The answer to the given sample input N = 5, arr[ ] = {2, 4, 1, 3, 5} is 3.
     This is because there are 3 inversions in the array:
        (2, 1) - Here, 2 comes before 1, violating the order.
        (4, 1) - 4 is ahead of 1, forming another inversion.
        (4, 3) - Lastly, 4 precedes 3, creating the third inversion */
    public static void inversioncount(int arr[])
        {
            int count=0;
            //basic logic using loops
    
           for(int i=0;i<arr.length;i++)
           {
           for(int j=i+1;j<arr.length;j++)
            {
                    if(arr[i]>arr[j])
                { 
                    count++;
                }
             }
         }
            System.out.println(count);
        }
        public static int mergeoptimized(int arr[],int left, int mid, int right)
        {
            int i=left,j=mid+1,k=0;
            int invCount=0;
            int temp[]=new int[(right-left+1)];

            while((i<=mid)&&(j<=right))
            {
                if(arr[i]<=arr[j])
                {
                    temp[k++]=arr[i++];
                }
                else{
                    temp[k++]=arr[j++];
                    invCount+=mid-i+1;  //Count inversions
                }
            }
            while(i<=mid)
            {
                    temp[k++]=arr[i++];
            }
            while(j<=right)
            {
                    temp[k++]=arr[j++];
            }
            // copy the merged array to the original array
            for(i=left,k=0;i<=right;i++,k++)
            {
                arr[i]=temp[k];
            }
            return invCount;
        }
        private static long mergeSortAndCount(int arr[],int left, int right)
        {
                long invCount=0;
                if(left<right)
                {
                        int mid=(left+right+1)/2;
                        invCount+=mergeSortAndCount(arr, left, mid-1);
                        invCount+=mergeSortAndCount(arr, mid, right);
                        invCount+=mergeoptimized(arr, left,mid-1, right);
                }
                return invCount;
        }
    public static void main(String[] args) {
       // int arr[]={2,4,3,5,1};
        int arr[]={1,2,1,1,1,2,2};
        inversioncount(arr);
        long answer=mergeSortAndCount(arr, 0, arr.length-1);
         System.out.print(answer);
    }
}