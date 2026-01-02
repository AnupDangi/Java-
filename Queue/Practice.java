import java.util.*;

public class Practice {
    
    // //Reverse first 
    // public static void reverseFirstKele(Queue<Integer>q,int k){
    //     Stack<Integer> stk=new Stack<Integer>();    
        
    //     //eg k=2
    //     //1,2,3,4,5 =Queue elements input
    //     //3,2,1,4,5
        
    //     for(int i=0;i<k;i++){
    //         stk.push(q.poll());//gets first element and remove ie push 1,2,3 into stack
    //     }
    //     while(!stk.isEmpty()){
    //         q.add(stk.pop());//push into stack from first index //add 3,2,1 into exesting queue
    //         //now it queue becomes 4,5,3,2,1 but this is added from rear 
    //     }
    //     //from index k to size use loop to get the index and k and add it at last
    //     for(int i=k;i<q.size();i++){
    //         int ele=q.poll();
    //         q.add(ele);
    //     }
    
    //     while (!q.isEmpty()) {
    //         System.out.println(q.poll());
    //     }
    // }

    //concept of priority Queue 
    //O(n)
    public static int ConnectNRopesWithMinCost(int arr[]){
        int profit=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        //adding all element and get element
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        // we will poll 2 element each time 
        while (pq.size()>=2) {
            //it takes all smallest element as it is priority Queue
            int p1=pq.poll();//p1-2 //4 //6
            int p2=pq.poll();//p2-3 //5 //9
            int p=p1+p2; //p=5 //15
            pq.add(p);
            profit=profit+p;
        }
        return profit;
    }
    public static int JobSequencingProb(){
        int result=0;

        return result;
    }
    public static void main(String[]args){
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        int k=5;
        //Output 50,40,30,10,60,70,80,90,100
        //reverseFirstKele(q,k);

        //2nd problem
        //Connect N ropes with minimum cost
        int arr[]={4,3,2,6};
       int result= ConnectNRopesWithMinCost(arr);
        System.out.println(result);

    }
}
