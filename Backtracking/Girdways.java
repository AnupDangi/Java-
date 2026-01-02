public class Girdways {
    
    // The problem of this question is to find the no of ways through we can move 
    //from starting cell (0,0) to  cell(n,m) max last postion

    //0(2^m+n)

    public static int gridways(int rows,int cols,int i,int j)
    {
        //base case
        if(i==rows-1 ||j==cols-1)
        {
            return 1;
        }
        else if(i==rows ||j==cols)
        {
            return 0;
        }
        int w1=gridways(rows,cols,i,j+1);
        int w2=gridways(rows,cols,i+1,j);
        int count=w1+w2;
        return count;

    }
    public static void main(String[]args)
    {
        int n=3, m=3;
        System.out.println(gridways(n,m,0,0));
    }
}
