import java.util.*;
public class WeakestSoilder {
    
    static class Soldier implements Comparable<Soldier>{
        int soldiers;
        int index;

      public Soldier(int soldiers,int index){
            this.soldiers=soldiers;
            this.index=index;
        }

        @Override
        public int compareTo(Soldier s2){
            if(this.soldiers==s2.soldiers){
                return this.index-s2.index;
            }
            else{
                return this.soldiers-s2.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int army[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
            int k=2;
        PriorityQueue<Soldier> pq=new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                //check for no of 1's in first row
                if(army[i][j]==1){
                   count+=1;
                }
                else{
                    count=0;
                }
            }
            pq.add(new Soldier(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().index);
        }
    }
}
