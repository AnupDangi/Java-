public class Gridwaysoptimized {
    
    // this is the optimized solution of grid ways whose time complexity is 0(n)
    // space complexity for this is 0(1)
    // for this i have used the optimized solution 
    public static int factorial(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int gridwaysoptimized(int rows,int cols)
    {
        
        if(rows==0||cols==0)
        {
            return 1;
        }
            // (n+m-2)!/((n-1)! *(m-1)!)
        int ways=factorial(rows+cols-2)/(factorial(rows-1)*factorial(cols-1));
          return ways;
    }
    public static void main(String[] args)
    {   
        int rows=3;
        int cols=3;
        System.out.println(gridwaysoptimized(rows,cols));
    }
}
