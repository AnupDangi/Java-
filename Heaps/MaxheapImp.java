import java.util.ArrayList;

public class MaxheapImp {
    
    static class Maxheap{
    ArrayList<Integer> arr=new ArrayList<>();

    //add into max heap
    public void add(int data){
        //get parent indx and child indx

        arr.add(data);
        int childidx=arr.size()-1;
        int parentidx=(childidx-1)/2;

        //compare left and right child then add into correct position 
        while (arr.get(childidx)>arr.get(parentidx)) {
            
            //swap
            int temp=arr.get(childidx);
            arr.set(childidx,arr.get(parentidx)); //set(index,value)
            arr.set(parentidx,temp);

            //update index
            childidx=parentidx;
            parentidx=(childidx-1)/2;
        }
    }


    public boolean isEmpty(){
        return arr.size()==0;
    }
    //get first element
    public int peek(){
        return arr.get(0);
    }


    public void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int maxId=i; //root is maximum

        //compare minId,left and right child
        if(left<arr.size() && arr.get(maxId)<arr.get(left)){
            maxId=left;
        } 
        if(right<arr.size() && arr.get(maxId)<arr.get(right)){
            maxId=right;
        }

        //if root is not maxithen 
        if(maxId!=i){
            
            //swap
            int temp=arr.get(i);
            arr.set(i, arr.get(maxId));
            arr.set(maxId, temp);

            heapify(maxId);
        }
    }

    public int remove(){
        //get first element 
        int data=arr.get(0);

        //swap firs and last node
        int temp=arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

        //delete last element 
        arr.remove(arr.size()-1);

        //always heapify from first index elemnt 
        heapify(0);
        return data;
    }
}
    public static void main (String[]args){
        ArrayList<Integer> arr=new ArrayList<>();
        Maxheap maxhp=new Maxheap();
        maxhp.add(0);
        maxhp.add(1);
        maxhp.add(5);
        maxhp.add(4);
        maxhp.add(6);

        while (!maxhp.isEmpty()) { //heap sort 
            System.out.println(maxhp.peek());
            maxhp.remove();
        }
    }
}
