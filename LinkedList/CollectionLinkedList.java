import java.util.LinkedList; //JCF ->optimized
public class CollectionLinkedList {
    
    
    public static void main(String[]args)
    {
        //Create objects int, float,boolean -> Integer,Float, Boolean
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(1);//1->
        ll.add(2);//1->2
        ll.add(0);//1->2->0
        ll.addFirst(5); //5->1->2->0
        ll.addLast(6); //5->1->2->0->6
        // ll.remove(); //just removes the first node
       // ll.removeAll(ll); //returns empty list by removing all the nodes
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);

    }
}

