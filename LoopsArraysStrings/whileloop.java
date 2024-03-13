import java.util.*;
public class whileloop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("\n 1.Press 1 to print string \n 2. Press 2 to Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
        switch (choice){
            case 1:
           System.out.println("Enter the number of terms you want to print your string ");
             int num=sc.nextInt();
              int condition=0;
            while (condition<num) {
            System.out.println("Hello World ");
            condition++;
            }
                break;
                case 2:System.exit(0);
                        break;
            default:System.out.println("Enter a valid choice");
                break;
          }
        }
    }
     }
