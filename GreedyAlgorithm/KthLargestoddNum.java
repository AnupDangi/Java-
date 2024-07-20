public class KthLargestoddNum {
    
    public static int KthLargestOdd(int L,int R,int k){
        if(L%2==0){
            L+=1;
        }
        int count=0;
        if(R%2==0){
            R-=1;
        }
        for(int i=L;i<=R;i+=2){
            count++;
        }
        if(k>count){
            return 0;
        }
        int KthLargestodd=R-(k-1)*2;
        return KthLargestodd;
    }
    public static void main(String[] args) {
        //Given 
        int L=-3;
        int R=3;
        int k=1;
        System.out.println(KthLargestOdd(L,R,k));
        
    }
}
