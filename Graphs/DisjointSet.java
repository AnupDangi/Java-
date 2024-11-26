import java.util.*;
public class DisjointSet {
    static int n= 7;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    //find parent
    public static int find(int x){ //0(4k)->0(1)
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    //union
    public static void union(int a,int b){//0(4k)->0(1) constant
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parB]++;
        }
        else if (rank[parA]<rank[parB]) {
                par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
    }
    public static void main(String[] args) {
        
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(2));
        System.out.println(find(4));
        union(1, 5);
    }
}
