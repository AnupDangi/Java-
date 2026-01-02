import java.util.*;
import java.util.Collections;
public class LonelyNumbersinArrList {
    
    // Code for lonely numbers 
    //lonely numbers mean that if the precedding number and postnumber does not appear in the list then 
    // it is a lonely number example
    // list=[10,6,5,8];
    // if the precedding of 10 ie 11 and number before 10 ie 9 does not appear in the list 
    // 10 is a lonely number as for 8 
    // formula to calculate lonely number is (i-1) and (i+1) is not present in the list

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        Collections.sort(nums); // Sort the list in ascending order
        ArrayList<Integer> list = new ArrayList<>(); // Initialize a new list to store lonely numbers

        for (int i = 1; i < nums.size() - 1; i++) {
            // Check if the current number is lonely
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i)); // Add the lonely number to the list
            }
        }
        
        // Check if the list contains only one element
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        // Check if the list contains more than one element
        if (nums.size() > 1) {
            // Check the first element for loneliness
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }

            // Check the last element for loneliness
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list; // Return the list of lonely numbers
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(10,6,5,8));
        System.out.println(findLonely(list));
    }
}
