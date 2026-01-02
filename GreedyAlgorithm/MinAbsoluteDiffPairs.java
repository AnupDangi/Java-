import java.util.Arrays;

public class MinAbsoluteDiffPairs {
 
    public static void main(String[]args){
        int A[]={1,2,3};
        int B[]={2,1,3};
        //ans=0
        Arrays.sort(A);
        Arrays.sort(B);
        int Minsum=0;
        if(A.length==B.length){
            for(int i=0;i<A.length;i++){
                Minsum+=Math.abs(A[i]-B[i]);
            }
        }
        System.out.println("MinSum Difference between two pairs is: "+Minsum);
    }
}
