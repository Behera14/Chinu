
// Program: Fibonacci Series using Recursive and Non-Recursive methods

import java.util.Scanner;

public class Fibonacci {

    // Recursive Method
    static int fibRecursive(int n) {
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Non-Recursive (Iterative) Method
    static void fibIterative(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("\nFibonacci Series using Recursion:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }

        System.out.println("\n\nFibonacci Series using Iteration:");
        fibIterative(n);

        sc.close();
    }
}
