public class QuickSort {

    //QuickSort 
    //Pivot and Partition
    //1.Pivot element
    //2.Parition around that pivot

    public static void quicksort(int arr[],int si,int ei)
    {
        //base case
        if(si>=ei)
        {
            return;
        }
        //last element
        int pidx=partition(arr,si,ei);//find the index for each 
        quicksort(arr,si,pidx-1); //left
        quicksort(arr, pidx+1, ei);//right 
        
    }

    public static int partition(int arr[],int si,int ei)
    {
        int pivot=arr[ei];
        int i=si-1; //to make place for elements smaller from pivot

        for(int j=si;j<ei;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void printarr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {   
            if(i==arr.length-1)
            {
                System.out.print(arr[i]);
                return;
            }
            System.out.print(arr[i]+" ,");
        }
    }
    public static void main(String[]args)
    {
        int arr[]={6,3,9,8,2,5};
        quicksort(arr,0,arr.length-1);
        printarr(arr);

    }
}
