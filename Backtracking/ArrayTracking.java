public class ArrayTracking {

    public static void changeArr(int arr[],int i,int value)
    {   
        //base case
        if(i==arr.length) //when arr.length is reached in call stack it will print
        {
            printarr(arr);
            return;
        }
        //recursion
        arr[i]=value;
        changeArr(arr, i+1, value+1); //fnc call step till arr.length
        arr[i]-=2; //Backtracking from the last index 

    }
    public static void printarr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
    }
    public static void main(String args[])
    {   
        int arr[]=new int[5];
        changeArr(arr,0,1);
        printarr(arr);
    }
}
