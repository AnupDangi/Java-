import java.util.*;
public class Area {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the radius of the circle: ");
    double r=sc.nextDouble();
    double area = 3.14 *r*r;
    System.out.print("The area of the circle :"+area);
    sc.close();
}
}
