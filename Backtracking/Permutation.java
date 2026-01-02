public class Permutation {

    public static void permutationsets(String str,String ans)
    {
        //base case
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        //recursion TC(n*n!)
        for(int i=0;i<str.length();i++)
        {
            char curr=str.charAt(i);
            //"abcde"->"ab"+"de"="abde"
            String newstr;//new string
            //substring is added substring found ie if index is chosen it is added and
            // the new string is passed to the newstring for call
            //In newstring find the substring from 0 to i the position and add the substring of next char
            newstr =str.substring(0, i)+str.substring(i+1);
            permutationsets(newstr,ans+curr);
        }
    }
    public static void main(String[]args)
    {
        String str="abc";
        String ans="";
        System.out.println("Permuatations of given string are");
        permutationsets(str,ans);
    }
}
