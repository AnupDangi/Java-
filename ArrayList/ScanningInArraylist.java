import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class ScanningInArraylist {
     
    public static void main(String[] args) {
    // ArrayList scan 
        int num;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        ArrayList<Integer> list1=new ArrayList<>();
        for(int i=0;i<num;i++)
        {
            int element=sc.nextInt();
            list1.add(element);
        }
        sc.close();
        for(int i=0;i<list1.size();i++)
        {
            System.out.println(list1.get(i)+" ");
        }
    }
} 
