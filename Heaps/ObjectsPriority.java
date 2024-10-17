import java.util.*;
public class ObjectsPriority {
    
    static class Student implements Comparable<Student>{//overriding
        String name;
        int rank;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq=new PriorityQueue<>();
        //PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A", 1));
        pq.add(new Student("B", 44));
        pq.add(new Student("C", 41));
        pq.add(new Student("D", 77));
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name +"->" +pq.peek().rank);
            pq.remove(); //0(logn)
        }
    }
}
