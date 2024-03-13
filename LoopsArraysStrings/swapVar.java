import java.util.*;
public class swapVar {
    public static void swap(int a,int b) {// Passing arguments 
        //here we are swapping using temporary variable 
        int temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println("Swapped value of a is "+a);
        System.out.println("Swapped value of b is "+b);
    }
    // creating a function swap without passing arguments
    public static void swap1() {
        Scanner sc=new Scanner(System.in);
        int var1,var2;
         var1=sc.nextInt();//let 2
         var2=sc.nextInt();//let 3
        var1=var1+var2;// First took sum of the variables then assigned to var1 --i.e var1=2+3=5
        var2=var1-var2;// then  the difference of updated var1 which is just assigned -var2 ----ie var2=var1(updated)5-3=2 so var2 is 2
        var1=var1-var2; //then the difference of var1 -var2 is done ----------- ie var1=updatedvar1 5- 2=3  
        System.out.println(var1);
        System.out.println(var2);
    }
    public static void main(String args[])
    {       
        int  a=5;
        int b=10;
        swap(a,b);
        swap1();
    }
}
