//N Queens find the no of queens which can be placed a board of 2*2 matrices
//count the no of ways we can place and print it
// Print one of the solution

public class NQueen {
    
    static int count=0;


    // public static void nQueens(char board[][],int row)
    // {   
    //     //base case
    //     if(row==board.length)
    //     {
    //        // printBoard(board);
    //         count++;
    //         return;
    //     }
    //     //column loop
    //     for(int j=0;j<board.length;j++)
    //     {
    //         if(isSafe(board,row,j))
    //         {
    //             board[row][j]='Q';
    //             nQueens(board,row+1); //function call  Place queen
    //             //keeping all the queens in other places as well
    //             board[row][j]='x';  //backtracking step by removing and replacing queen
    //         }
    //     }


    public static boolean nQueens(char board[][],int row)
    {   
        //base case
        if(row==board.length)
        {
           // printBoard(board);
           // count++;
            return true;
        }
        //column loop
        for(int j=0;j<board.length;j++)
        {
            if(isSafe(board,row,j))
            {
                board[row][j]='Q';
                if(nQueens(board,row+1)){
                    return true;
                }
                board[row][j]='x'; //backtracking
            }
        }
        return false;
    }
    public static boolean isSafe(char board[][],int row,int col)
    {
        //vertical up it only checks the vertical ie 
        //decrement rows and check if any quuen is there or not 
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }
        //diagonal left up it checks the rows and column both rows and columns 
        //move one step up and side 
        for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j-- )
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        //diagonal right up 
        //move one step right from the current position increment the col ie j and
        // decrement of row ie diagonal
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }

        public static void printBoard(char board[][])
        {
                System.out.println("----------Chess Board---------");
                for(int i=0;i<board.length;i++)
                {
                    for(int j=0;j<board.length;j++)
                    {
                        System.out.print(board[i][j]+" ");
                    }
                    System.out.println(" ");
                }
        }
    public static void main(String[] args) {
        int n=4;
        //generally in a real chess board there are 8*8 rows and columns ie 64 places to move
        char board[][]=new char[n][n];
        //initialize
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='x';
            }
        }
        // nQueens(board,0);
        if(nQueens(board, 0))
        {
            System.out.println("solution is possible");
            printBoard(board);
        }
        else
        {
            System.out.println("Solution is not possible");
        }
        //System.out.println("total number of ways to solve n queens ="+count);
    }
}
