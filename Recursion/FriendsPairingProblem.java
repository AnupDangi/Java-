public class FriendsPairingProblem {
    
    /*given n friends, each one can remain single or can be paird up with some other friend. 
    Each friend can be paird only once. Find out the total number of ways in which friends can remain 
    single or paired or can be paired up. */
    
    public static int friendspairing(int n)
    {
        //base case
        if(n==1||n==2)
        {
            return n;
        }
        //choice
        //single 
        int fnm1=friendspairing(n-1);

        //pair
        // int fnm2=friendspairing(n-2);
        // int pairways=(n-1)*fnm2;

        // //totways
        // int totways=fnm1+fnm2;
        // return totways;
        return friendspairing(n-1)+(n-1)*friendspairing(n-2);
    }
    public static void main(String[] args)
    {
            System.out.println(friendspairing(5));

    }
}
