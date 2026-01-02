import java.io.*;
public class NumberofParaenthesisCombination {
    
    static int count=0;
    public static void parathesisCombination(int n,char arr[],int pos,int open,int close){

        //always starts with open
       //print the arr when the close reaches the length of n
        if(close==n){
            //print the arr
            count++;
            System.out.println("Combination: "+count);
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }    

        //start filling the arr
        if(open>close){
            arr[pos]=')';
            parathesisCombination(n, arr, pos+1, open, close+1);
        }
        if(open<n){
            arr[pos]='(';
            parathesisCombination(n, arr, pos+1, open+1, close);
        }
    }

    public static void printParathesis(int n,char arr[]){
        if(n>0){
            parathesisCombination(n, arr, 0, 0, 0);
            return;
        }
    }
    public static void main(String[] args) {
        int n=3;
        char arr[]=new char[2*n];
       printParathesis(n, arr);
    }
}
