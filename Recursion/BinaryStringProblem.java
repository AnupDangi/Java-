public class BinaryStringProblem {
    

    // print not consecutive ones string
    // eg valid --- 001010
    //eg valid -------- 110100
    // not valid -------1110111

    //Print all binary strings of size N without consecutve ones strings
    // the algorithm is
    // first take n number of strings 
    //keep track of lastplace string so that we dont encounter two ones together
    //pass the string as empty first and then the exection is given below

    public static void printBinarystrings(int n,int lastplace,String str)
    {
        //base case
            if(n==0)
            {
                System.out.println(str);
                return;
            }
          // work
        printBinarystrings(n-1, 0, str+("0")); 
        if(lastplace==0)
        {
            // sit 0 on chair n
            printBinarystrings(n-1, 1, str+("1"));
      }
    }
    public static void main(String[]args)
    {
        printBinarystrings(3, 0, "");
    }
}

