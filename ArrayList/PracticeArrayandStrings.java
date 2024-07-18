public class PracticeArrayandStrings {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int size=arr.length;
        String sarr[]={"abc","def"};
        int size2=sarr.length;
        String str="Hello";
        char carr[]=str.toCharArray(); 
        //convert string to char array
        for(int i=0;i<str.length();i++)
        {
            System.out.print("'"+carr[i]+"'"+" ,");
        }
        System.out.println(size+" "+size2);
    }
}
