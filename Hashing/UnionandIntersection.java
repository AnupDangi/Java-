import java.util.*;
public class UnionandIntersection {
    
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer>set=new HashSet<>();
        
        //union
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        //union output
        System.out.println("union="+set.size());
        System.out.println(set);

        set.clear();
        //intersection
        //1. add all elements from arr1 into set
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                System.out.print(arr2[i]+",");
                set.remove(arr2[i]);

            }
        }
        System.out.println("intersection="+count);
    }
}