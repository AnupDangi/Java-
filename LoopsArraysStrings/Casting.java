import java.util.*;
public class Casting {
    public static void main(String[] args) {
   /*  int a=25;
    long b=a;    //downcasting is possible ie explicit conversion should be done by the user 
    //long a=25;
    //int b=a;      // upcasting is not possible by java itself ie implicit conversion is not possible without user
    System.out.print(b);
    // Conversion of type casting */
    Scanner sc =new Scanner(System.in);
    float a= 12.66f;        //explicit conversion done by user ie narrowing
    int b= (int)a;
    System.out.print(b);
    char ch='a';
    int num=ch;
    System.out.print(num);
    sc.close();
}
}
