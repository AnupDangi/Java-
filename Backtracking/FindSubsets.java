public class FindSubsets {
    
    public static void subsets(String str,String ans, int i)
    {
        //base case
        if(i==str.length())
        {   
            if(ans.length()==0)
            {
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        //recursion Yes if the pair is made add with ans 
        subsets(str, ans+str.charAt(i), i+1);
        //No choice if not call the next index
        subsets(str, ans, i+1);
    }

    public static void  main(String[]args)
    {
        String str="abc";
        stringToCharArray(str);
        String ans="";
        System.out.println("This is the subset of a string");
        subsets(str ,ans,0);
        
    }
    public static void stringToCharArray(String str)
    {
        System.out.println("This is the character array");
        char ch[]=new char[str.length()];
        //copy char from str to char arr
        for(int i=0;i<str.length();i++)
        {
            ch[i]=str.charAt(i);
        }
        for(int i=0;i<ch.length;i++)
        {
            System.out.print(ch[i]+" ");
        }
        System.out.println(" ");
    }
}
