public class sudokuSolver {
    
    public static boolean isSafe(int sudoku[][],int row,int col,int digit)
    {
        // for column
        for(int i=0;i<=8;i++)
        {
            if(sudoku[i][col]==digit)
            {
                return false;
            }
        }
        // for row
        for(int j=0;j<=8;j++)
        {   
            if(sudoku[row][j]==digit)
            {
                return false;
            }
        }
        //for grid
        int sr=(row/3)*3;
        int sc=(col/3)*3 ;
        // 3*3 grid
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(sudoku[i][j]==digit)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolveer(int sudoku[][],int row, int col)
    {
        //base case
        if(row==9 && col==0)
        {
            return true;
        }

        //recursion
        // updatae the row as nextrow easier for traverse in a loop 
        //update col each time
        int nextrow=row,nextcol=col+1;
        if(col+1==9)
        {
            //traverse to other row and reset the col as 0 
            nextrow=row+1;
            nextcol=0;
        }

        // this is condition for set element which is set in matrix
        if(sudoku[row][col]!=0)
        {
            return sudokuSolveer(sudoku,nextrow,nextcol);
        }
        for(int digit=1;digit<=9;digit++)
        {
            if(isSafe(sudoku,row,col,digit))
            {
                sudoku[row][col]=digit;
                if(sudokuSolveer(sudoku,nextrow,nextcol)) // traverse to find another sol in same row
                {
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(sudoku[i][j] +" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args)
    {
        int sudoku[][]={{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};

        if(sudokuSolveer(sudoku,0,0))
        {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }
        else{
            System.out.println("Solution does not exists");
        }
    }
}
