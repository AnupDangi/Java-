import java.util.*;
public class Balancedparantheses {
    

    public static void balancepairs(char str[],int pos,int n,int open,int close,int index[]){
        if(close==n){
            index[0]++;
            System.out.println("Combination "+index[0]);
            for(int i=0;i<str.length;i++){
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        else{
            if (open>close) { //close the bracket if open is greater
                str[pos]='}';
                balancepairs(str, pos+1, n, open, close+1,index);
            }
            if(open<n){//add the open braces "{"
                str[pos]='{';
                balancepairs(str, pos+1, n, open+1, close,index);
            }
        }
    }
    public static void printBalancedpairs(int n){
        char str[]=new char[2*n];
        int index[]={0};
        balancepairs(str,0,n,0,0,index);
        return;
    }
    public static void main(String[] args) {
        int n=3;
        printBalancedpairs(n);
    }
}
