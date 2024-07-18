import java.util.*;
public class TwoDArray {

    public static boolean search(int matrix[][],int key)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
              if (matrix[i][j]==key) {
                System.out.println("found at cell ("+(i+1)+","+(j+1)+")");
                return true;
              }
            }
        }
        System.out.println("key not found");
        return false;
    }
    public static boolean largest(int matrix[][])
    {
        int max=matrix[0][0];
        int min=matrix[0][0];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
              if (matrix[i][j]>max) {
                 max=matrix[i][j];
              }
              else{
                min=matrix[i][j];
              }
            }
        }

        System.out.println("Largest element is "+max);
        System.out.println("Largest element is "+min);
        return false;
    }
    public static void main(String[] args)
    {
        int matrix[][]=new int [3][3];
        Scanner sc =new Scanner(System.in);
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println("");
        }
       int  key=sc.nextInt();
        search(matrix,key);
        largest(matrix);
    }
}