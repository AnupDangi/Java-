import java.util.*;
public class KandaneMaxSumArray {
    public static void MaxSum(int number[])
    {
        int MaxSum=Integer.MIN_VALUE;
        int CurrSum=0;
        for(int i=0;i<number.length;i++)
        {
            CurrSum=CurrSum+number[i];

            if (CurrSum<0)
             {
                CurrSum=0;
            }
            
            MaxSum=Math.max(CurrSum,MaxSum);
        }
        System.out.println("max subaray sum is:"+MaxSum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number[]={-2,-3,4,-1,-2,1,5,-3};
        MaxSum(number);
        }
}
