import java.util.ArrayList; //It is a class
public class ArrayListBasics {
    public static void main(String[] args) {
        //Array list is java collection framework
        //other objects datatypes String or Boolean or Character 
        // It is a dynamic array 
        // clasname objectname =new classname();
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        ArrayList<Boolean> list3=new ArrayList<>();

        // Operation

        // Integer // add time complexity is 0(1) for each element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(1, 11); //O(n) it manipulates dynamically the previous 
        // assigned value at that index
       
        System.out.println(list);
        // find the size of the arraylist
        System.out.println(list.size());
        
        //Get Operation 0(1)
        int element=list.get(2);
        System.out.println("Index element is "+element);

        //Delete 0(n)
        //list.remove(2);
        //System.out.println(list);
        
        //Set Element 0(n)
        list.set(2, 10);
        System.out.println(list);

        // Contains to check the value 
       boolean value= list.contains(2);
        System.out.println(value);
        
        //looping over the arraylist
        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
