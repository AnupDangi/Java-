import java.util.Arrays;

public class CycleSort{

    public static int[] cycleSort( int arr[])
    {
        //concept index=val-1
        for(int i=1;i<=arr.length;i++)
        {
            int correctindx=arr[i]-1;
            if(arr[i]!=arr[correctindx])
            {
                //swap with the index value 
                     int temp=arr[correctindx];
                     arr[correctindx]=arr[i];  
                     arr[i]=temp;
                }
                else{
                    break;
                }

        }
        return arr;
    }
    public static void quickSort(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int pivot=arr[0];
            if(pivot>arr[i+1])
            {
                //left partition
                pivot=arr[i+1];
                arr[i]=pivot;
            }
            else{
                pivot=arr[i+1];
                arr[i]=pivot;
            }

        }
    }
    public static void printarr(int result[])
    {
        for(int i=1;i<=result.length;i++)
        {
            System.out.print(result[i]+" ");
        }
        System.out.println(" ");
    }
    public static void main(String[]args)
    {
        int arr[]={3,5,2,1,4};
       int result[]= cycleSort(arr);
        //System.out.println(Arrays.toString(arr));
        printarr(result);
    }
}