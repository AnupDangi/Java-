import java.util.*;
public class Pass_fail {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int marks=sc.nextInt();
        String reportCard =marks>=33? "Pass":"Fail";
        System.out.println(reportCard);
    }
}
