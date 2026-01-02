import java.util.*;
public class AllPatterns {
    //This is the method for printing Invertedhalfpyramid
    public static  void rotatedhalfpyramid(int rows, int col)
    {
        System.out.println("\n -----------------This is a rotatedhalfpyramid----------------- \n");
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=rows-i;j++)
            {
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println(" \n\n\n");
    }
     //This is the method for printing halftraingle
    public static  void rightangledtriangle(int rows, int col)
    {
        System.out.println("\n ---------------------This is a halftriangle------------------------- \n");
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }
     //This is the method for printing Invertedtriangle
    public static  void Invertedhalfpyramid(int rows, int col)
    {
        System.out.println("\n ------------------------This is a invertedhalfpyramid----------------------\n");
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=rows-i+1;j++)
            {
                System.out.print(j+" ");
            }
            System.out.println("");
        }
        
    }
    // This is a method for printing Floyd Triangle

    public static void Floydtriangle(int rows, int col) {
        System.out.println("\n -------------------This is a floyd triangle--------------------- \n");
        int counter=1;
        for(int i=1;i<=rows;i++)
        {
            //To print values using counter 
            for(int j=1;j<=i;j++)
            {
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println("");
        }
    }
    //This is a method for printing 0-1 Triangle
    public static void Zero_OneTriangle(int rows,int col)
    {   
        System.out.println("\n -------------------This is a Zero-One triangle--------------------- \n");
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if((i+j)%2==0)
                {
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println("");
        }
    }
    //This is a method for printing butterfly pattern
    public static void butterfly(int rows)
    {
        System.out.println("\n ---------------This is a butterfly Pattern------------------\n");
        //1st half of butterfly
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            for(int spaces=1;spaces<=(rows-i)*2;spaces++)
           { 
                System.out.print(" ");
             }

          for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        //Second half of butterfly
        for(int i=rows;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            for(int spaces=1;spaces<=(rows-i)*2;spaces++)
           { 
                System.out.print(" ");
             }

          for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    //This is a solidrhombus pattern
    public static void solidrhombus(int rows)
    {
        System.out.println("\n----------This is the solid rhombus-----------------\n");
        for(int i=1;i<=rows;i++)
        {
            for(int spaces=1;spaces<=rows-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=rows;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    //This is a method to print hollow rhombus
    public static void hollowrhombus(int rows)
    {
        System.out.println("\n -----------------This is a hollow rhombus----------------------\n");
        for(int i=1;i<=rows;i++)
        {
            for(int spaces=1;spaces<=rows-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=rows;j++)
            {
                if(i==1||j==1||i==rows||j==rows)
                System.out.print("*");
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    //This is method to print diamond pattern
    public static void diamond(int rows)
    {
        System.out.println("\n-------------------This is a diamond pattern----------------\n");
        //First half of diamond pattern ie pyramid
        for(int i=1;i<=rows;i++)
        {
            for(int spaces=1;spaces<=rows-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        //Second half of diamond pattern ie inverted pyramid
        for(int i=rows;i>=1;i--)
        {
            for(int spaces=1;spaces<=rows-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int col=sc.nextInt();
        rotatedhalfpyramid(rows,col);
        rightangledtriangle( rows,  col);
        Invertedhalfpyramid(rows,col);
        Floydtriangle(rows, col) ;
        Zero_OneTriangle(rows, col);
        butterfly(rows);
        solidrhombus(rows);
        hollowrhombus(rows);
        diamond(rows);
    }

}
