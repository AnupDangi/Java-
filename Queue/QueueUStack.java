import java.util.Stack;

public class QueueUStack {

    class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // Non-static nested class for Method1
        class Method1 {
            // Adding an element in O(n) time
            public void add(int data) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(data);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }

            // Removing an element in O(1) time
            public int remove() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                return s1.pop();
            }

            // Peeking the front element in O(1) time
            public int peek() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                return s1.peek();
            }
        }

        // Non-static nested class for Method2
        class Method2 {
            // Adding an element in O(1) time
            public void add(int data) {
                s1.push(data);
            }

            // Removing an element in O(n) time
            public void remove() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return;
                }
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                s2.pop();
            }

            // Peeking the front element in O(n) time
            public int peek() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                return s2.peek();
            }
        }
    }

    public static void main(String[] args) {
        QueueUStack qustk = new QueueUStack();
        QueueUStack.Queue q = qustk.new Queue(); // Creating an instance of Queue

        System.out.println("Using Method 1:");
        QueueUStack.Queue.Method1 mth1 = q.new Method1(); // Creating an instance of Method1
        mth1.add(2);
        mth1.add(4);
        mth1.add(6);
        while (!q.isEmpty()) {
            System.out.println(mth1.peek());
            mth1.remove();
        }

        // Resetting the stacks for Method 2
        q.s1.clear();
        q.s2.clear();

        System.out.println("Using Method 2:");
        QueueUStack.Queue.Method2 mth2 = q.new Method2(); // Creating an instance of Method2
        mth2.add(2);
        mth2.add(4);
        mth2.add(6);
        while (!q.isEmpty()) {
            System.out.println(mth2.peek());
            mth2.remove();
        }
    }
}


// public class QueueUStack {

// static class Queue{
// static Stack<Integer> s1=new Stack<>();
// static Stack<Integer> s2=new Stack<>();

// public static boolean isEmpty(){
// return s1.isEmpty();
// }

// //Method 1 - ie taking adding time 0(n) and pushing time 0
// //Add 0(n)
// public static void add(int data){
// while(!s1.isEmpty()){
// s2.push(s1.pop());
// }
// s1.push(data);

// while(!s2.isEmpty()){
// s1.push(s2.pop());
// }
// }

// //Remove 0(1)
// public static int remove(){
// if(isEmpty()){
// System.out.println("Queue is empty");
// return -1;
// }
// return s1.pop();
// }
// public static int peek(){
// if (isEmpty()) {
// System.out.println("Queue is Empty");
// return -1;
// }
// return s1.peek();
// }

// }
// public static void main(String[] args) {
// Queue q=new Queue();
// q.add(2);
// q.add(4);
// q.add(6);
// while(!q.isEmpty()){
// System.out.println(q.peek());
// q.remove();
// }
// }
// }
