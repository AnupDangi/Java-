public static int power(int n) 
    {
        if(n==0)
        {
            return 1;
        }
        return n*(int)Math.pow(n,n-1);
    }