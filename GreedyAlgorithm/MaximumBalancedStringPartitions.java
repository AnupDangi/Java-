public class MaximumBalancedStringPartitions {
    

    public static int maxbalancedStrings(String str){
        int n=str.length();

        int lcount=0;
        int rcount=0;
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='L'){
                lcount++;
            }
            else{
                rcount++;
            }
            if(lcount==rcount){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*We have balanced stringstr of sizeN with an equal number of LandR,
        the task is to find a maximum number X,such that a given string can be partitioned
        into X balanced substring.Astring is called to be balanced if the number of ‘L’s in the string 
        equals the number of ‘R’s.
        Input: “LRRRRLLRLLRL”Output: 3
         */
        String str="LRRRRLLRLLRL";
        System.out.println("Count balanced partitions: "+maxbalancedStrings(str));
    }
}
