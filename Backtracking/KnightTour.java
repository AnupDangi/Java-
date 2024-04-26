public class KnightTour {


    // initialize the static value for board max size 
    static int N=8;

    // check the safe condition for the knight and return ie ie in (0,0) minimum and max border 
    // ie (n-1,n-1) then return as sol value is -1 ie no solution till now and return true 
    //for the particular cell
    public static boolean isSafe(int x, int y, int sol[][])
    {
            return (x>=0 && x <N && y>=0 && y<N && sol[x][y]==-1);           
    }

    // just printing the solution
    public static void printSolution( int sol[][])
    {
        for(int x=0;x<N;x++)
        {
            for(int y=0;y<N;y++)
            {
                System.out.print(sol[x][y]+" ");
            }
            System.out.println();
        }
    }

    // solveKT ie knight tour throughout the board
    public static boolean SolveKT()
    {
        int sol[][]=new int [8][8];
        for(int x=0;x<N;x++)
        {
            for(int y=0;y<N;y++)
            {
                sol[x][y]=-1;
            }
        }
            // places of movement of knight one cell to another
            int xMove[]={2,1,-1,-2,-2,-1,1,2};
            int yMove[]={1,2,2,1,-1,-2,-2,-1};

            //As the knight starts from cell(0,0)
            sol[0][0]=0;
            if(!solveKTUtil(0,0,1,sol,xMove,yMove))
            {
                System.out.println("Solution doesnot exists");
                return false;
            }
            else{
                printSolution(sol);
                return true;
            }   
    }
    // solve the knight util function 
    // pass the parameters to move in direction and count the max number of directions
    public static boolean solveKTUtil(int x, int y ,int movei,int sol[][],int xMove[], int yMove[])
    {
        // initialized the new x and new y cell places 
        int k, next_x, next_y;
        // max moves is n*n
        if(movei==N*N)
        {
            return true;
        }
        for(k=0;k<8;k++)
        { 
            // through the board movement of x and y is updated
            next_x=x+xMove[k];
            next_y=y+yMove[k];

            // call the safe function 
            if(isSafe(next_x, next_y, sol))
            {
                sol[next_x][next_y]=movei;
           
            //call another move place for another cell movement of knight 
            if(solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove))
            {
                return true;
            }
            else{
                    sol[next_x][next_y]=-1;//Backtracking to the place 
            }
        }
    }
        return false;
    }

    public static void main(String[]args)
    {
        SolveKT();
    }
}
