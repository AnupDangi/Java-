import java.util.*;
public class FloodFillAlgorithm {
    
    public static void helper(int [][] image,int sr,int sc,boolean visited[][],int color,int orgCol){ //0(m*n)
        //base case if goes negative boundary(-) or higher boundary(+) ,already visited or image[sr][sc] is not equal to orgcol
        if(sr<0 ||sc<0||sr>=image.length || sc>=image[0].length || visited[sr][sc] || image[sr][sc]!=orgCol){
            return;
        }
        image[sr][sc]=color;    
        visited[sr][sc]=true;    
        //move left
        helper(image, sr, sc-1, visited,color, orgCol);

        //move right
        helper(image, sr, sc+1, visited, color,orgCol);

        //move up 
        helper(image, sr-1, sc, visited, color,orgCol);

        //move down 
        helper(image, sr+1, sc, visited, color,orgCol);
    }

    public static int [][] floodFill(int image[][],int sr,int sc,int  color){
        //visit 
        boolean visited[][]=new boolean[image.length][image[0].length];

        helper(image,sr,sc,visited,color,image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        int image[][]={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        floodFill(image,sr,sc,color);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
