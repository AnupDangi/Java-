import java.util.Scanner;

public class AffixZero {
    public static String affixzero(int m, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = m; i < n; i++) {
            sb.append("0");
            sb.append(i+" ");
        }
        sb.append(n);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the start of range (m): ");
        int m = sc.nextInt();

        System.out.print("Enter the end of range (n): ");
        int n = sc.nextInt();

        // Generate and print the range of numbers
        System.out.println("Range of numbers:");
        for (int i = m; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Generate the affixed zero string
        String result = affixzero(m, n);
        System.out.println("Result: " + result);

        sc.close();
    }
}
