import java.util.*;
public class BipartieUsingAdmatrix {  
    public static boolean checkbipartite(int admat[][]){
        int V=admat.length;
        int color[]=new int[V];
        Arrays.fill(color,-1); //initialize with color -1
        
        //take help of Queue as well 
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<admat.length;i++){
            //Implement BFS and add first elemnt into q 
            if(color[i]==-1){
                q.add(i);
                color[i]=0; //start with first node as 0
                
                while(!q.isEmpty()){
                    int curr=q.remove();

                    //traverse all nodes and check adjacency 
                    for(int j=0;j<V;j++){
                        if(admat[curr][j]==1){ //edge exist 
                            if(color[j]==-1){
                                color[j]=1-color[curr];  
                                q.add(j);
                            } 
                        else if(color[j]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
    }
        return true;
    }
    public static void main(String[] args) {
        int V=5;
        Scanner sc=new Scanner(System.in);
        int admat[][]=new int[V][V];
         //store in adjancey matrix
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                admat[i][j]=sc.nextInt();
            }
        }
    //    //print adjancecy matrix
    //     for(int i=0;i<V;i++){
    //         for(int j=0;j<V;j++){
    //             System.out.print(admat[i][j]+" ");
    //         }
    //         System.out.println();
    //     }

        //check for bipartite
        System.out.println(checkbipartite(admat));
    }
}
