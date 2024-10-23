import java.util.*;
public class ImplementationofHashMap {
    
    static class HashMap<K,V>{//generics
        private class Node{
        K key;
        V value;
        
        public Node(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
        private int n;

        private int N;
        //array of linkedlist
        private LinkedList<Node> buckets[]; //N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        //Implement put 
            private int hashFunction(K key){
                int hc=key.hashCode(); //return hashcode for the key 
                //code may be 122323211 or anything in integer +ve or -ve
                return Math.abs(hc)%N; 
            } 

            private int SearchinLL(K key,int bi){
                LinkedList<Node> ll=buckets[bi];
                int di=0; //data index

                for(int i=0;i<ll.size();i++){
                    Node node=ll.get(i);
                    if(node.key==key){
                        return di;
                    }
                    di++;
                }
                return -1;
            }
            @SuppressWarnings("unchecked")
            private void rehash(){
                LinkedList<Node> oldbucket[]=buckets;
                N=2*N;
                for(int i=0;i<buckets.length;i++){
                    buckets[i]=new LinkedList<>();
                }
                //nodes -> add in bucket
                for(int i=0;i<oldbucket.length;i++){
                    LinkedList<Node> ll=oldbucket[i];
                    for(int j=0;j<ll.size();j++){
                        Node node=ll.get(i);
                        put(node.key, node.value);
                    }
                }

            }
            public void put(K key,V value){ //0(lambda)-> 0(1)constant
                //get bucketindex
                int bi=hashFunction(key);
                //search inside linkedlist 
                int di=SearchinLL(key,bi); //validindx 1,invalid ie -1

                if(di==-1){
                    buckets[bi].add(new Node(key, value));
                    n++;
                }
                else{
                    Node node=buckets[bi].get(di);
                    node.value=value;
                }
                double lamda=(double)n/N;
                if(lamda>2.0){
                    rehash();
                }
            }
            public boolean containsKey(K key){
                //find bucket index 
                int bi=hashFunction(key);
                //search inside linkedlist 
                int di=SearchinLL(key,bi); //validindx 1,invalid ie -1

                if(di==-1){
                   return false;
                }
                return true;
            }
            public V get(K key){
                int bi=hashFunction(key);
                //search inside linkedlist 
                int di=SearchinLL(key,bi); //validindx 1,invalid ie -1

                if(di==-1){
                   return null;
                }
                else{
                    Node node=buckets[bi].get(di);
                    return node.value; 
                }
            }

            public V remove(K key){
                int bi=hashFunction(key);
                //search inside linkedlist 
                int di=SearchinLL(key,bi); //validindx 1,invalid ie -1

                if(di==-1){
                   return null;
                }
                else{
                  Node node=buckets[bi].remove(di);
                  n--;
                  return node.value;
                }
            }
            public ArrayList<K> keySet(){
                ArrayList<K> keys=new ArrayList<>();

                for(int i=0;i<buckets.length;i++){
                    LinkedList<Node> ll=buckets[i];
                    for(Node node:ll){
                        keys.add(node.key);
                    }
                }
                return keys;
         }

        public boolean isEmpty(){
            return n==0;
        }
        private int getsize(){
            return n;
        }
  }
        public static void main(String[] args) {
            HashMap<String,Integer> hmap=new HashMap<>();
            hmap.put("India",100);
            hmap.put("China", 150);
            hmap.put("US", 50);
            hmap.put("Nepal", 5);
       
        ArrayList<String> keys=hmap.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println(hmap.get("India"));
        System.out.println(hmap.remove("India"));
        System.out.println(hmap.get("India"));

        System.out.println(hmap.getsize());
    }
}