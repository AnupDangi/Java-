public class PossiblePairs {
    public static void main(String[]args)
    {
        int list[]={1,2,3,4,5};
        int length=list.length;
        //Printing all the pairs possible pairs
        //0(n^2)
        int target=5;
        for(int i=0;i<length;i++)
        {
            for(int j=i+1;j<length;j++)
            {
                if(list[i]+list[j]==target)
                {
                    System.out.print("("+list[i]+list[j]+")");
                }
               // System.out.print("("+list[i]+","+list[j]+")"+","+" ");
            }
            System.out.println("");
        }
    }
}
