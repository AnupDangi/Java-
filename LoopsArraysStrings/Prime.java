// import java.util.Scanner;
// public class Prime {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         while (true) {
//             System.out.println("\n1 Check for prime \n 2. Exit");
//             System.out.println("Enter your choice ");
//             int choice=sc.nextInt();
//             int flag=0;
//             switch (choice) {
//       case 1:{
//             System.out.println("Enter a num to check prime or not ");
//             int num=sc.nextInt(); 
//          if (num==2) {
//             System.out.println(num+" is prime ");;
//         }
//         else{
//             for(int i=2;i<num;i++)
//             {
//                 if (num%i==0) {
//                      flag=0;
//                      break;
//                 }
//                 else{
//                     flag=1;
//                     break;
//                 }
//             }
//             if (flag==1) {
//                 System.out.println(num+"is prime");
//             }
//             if (flag==0)
//                 {
//                 System.out.println(num+"is not prime");
//             }
//         }
//        break;
//     }
//         case 2:
//          System.exit(0);
//             break;
//         default: System.out.println("Enter a valid choice");
//         break;
//         }
//     }
// }
// }
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Check for prime\n2. Exit");
            System.out.println("Enter your choice ");
            int choice = sc.nextInt();
            int flag = 0;

            switch (choice) {
                case 1: {
                    System.out.println("Enter a num to check prime or not ");
                    int num = sc.nextInt();
                    if (num < 2) {
                        System.out.println(num + " is not prime");
                    } else if (num == 2) {
                        System.out.println(num + " is prime");
                    } else {
                        flag = 1;
                        for (int i = 2; i <= Math.sqrt(num); i++) {
                            if (num % i == 0) {
                                flag = 0;
                                break;
                            }
                        }
                        if (flag == 1) {
                            System.out.println(num + " is prime");
                        } else {
                            System.out.println(num + " is not prime");
                        }
                    }
                    break;
                }
                case 2:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }
}


