import java.util.*;
public class IntrotoHeap {
    
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();

        //Implementing min heap 
        public void add(int data){
            //1.add at last
            arr.add(data);
            
            //2.Parent index
            //child's index
            int childidx=arr.size()-1;
            int parent=(childidx-1)/2;

            while(arr.get(childidx)<arr.get(parent)){ //time complexity 0(logn) because i am moving towards each new level so the maximum level height is 0(H)
                //swap
                int temp=arr.get(childidx);
                arr.set(childidx, arr.get(parent));
                arr.set(parent,temp);

                //update child and parent indices
                childidx=parent;
                parent=(childidx-1)/2;
            }
        }
        public int peek(){
            //to get minimum value in minheap
            return arr.get(0);
        }
        public void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minId=i; //assume root is minimum

            //compare minId with left and right child
            if(left<arr.size() && arr.get(minId)>arr.get(left)){
                minId=left;
            }

            if(right<arr.size() && arr.get(minId)>arr.get(right)){
                minId=right;
            }

            //if minId is not equals 0 or i
            if(minId!=i){

                //swap
                int temp=arr.get(i);
                arr.set(i, arr.get(minId));
                arr.set(minId,temp);
                
                heapify(minId); 
            }
        }
        public int remove(){
            int data=arr.get(0);

            //step1 swap first and last
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
        
            //step 2 -delete last
            arr.remove(arr.size()-1);

            //step 3 -fix my heap
            heapify(0);
            return data;
        }
    
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
       Heap minhp=new Heap();
        minhp.add(3);
        minhp.add(4);
        minhp.add(1);
        minhp.add(5);

        while (!minhp.isEmpty()) {
            System.out.println(minhp.peek());
            minhp.remove();
        }

    }
}