import java.util.Arrays;

// time complexity (nlogn)
// space complexity(n) 
// This is the mergesort algorithm using divide and conquer
public class MergeSort{
    
    public static int inbuiltsort(int arr[])
    {
            Arrays.sort(arr);//first sort in 
            System.out.println(Arrays.toString(arr));//dont directly call this arrays.sort because its a void type and it
            // should be converted to string
             return 0;
    }

    public static int mergesort(int arr[],int si,int ei)
    {
        //base case
        if(si>=ei)
        {
            return 1;
        }
        //logic using recursion
        int mid=si+(ei-si)/2; //finding mid element
        mergesort(arr, si, mid);//left part sort
        mergesort(arr, mid+1, ei);//right part sort
        merge(arr,si,mid,ei);//call the merge sort to sort both left and right part
        //and merge them in a single arr
        return 0;
    }
    public static void merge(int arr[],int si, int mid,int ei)
    {
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1;//iterator for right part
        int k=0; // iterator for temp arr
        while(i<=mid &&j<=ei)
        {
            if(arr[i]<arr[j])
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                j++;  
            }
            k++;
        }
        //left part remaining single element
        while(i<=mid)
        {
            temp[k++]=arr[i++];
        }
        //right part remaining single element
        while(j<=ei)
        {
            temp[k++]=arr[j++];
        }

        //copy temp to original arr
        for(k=0,i=si;k<temp.length;k++,i++)
        {
            arr[i]=temp[k];
        }
    }
    //print the sorted array
    public static void printsortedarr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        //mergesort();
        int a[]={1,3,2,3,4};
        int merge[]={8,2,3,4,5,7,100};
        inbuiltsort(a);
        mergesort(merge,0,merge.length-1);
        printsortedarr(merge);
        int an[]={1,2,3};
        
        for(int i=0;i<an.length;i++)
        {
            an[i]=2;
        }
        System.out.println("\n"+Arrays.toString(an));

    }
}
