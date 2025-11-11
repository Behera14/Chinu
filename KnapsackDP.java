// Program: 0/1 Knapsack Problem using Dynamic Programming

import java.util.Scanner;

public class KnapsackDP {

    // Function to solve 0/1 Knapsack using DP
    static int knapSack(int capacity, int[] weight, int[] value, int n) {
        int[][] K = new int[n + 1][capacity + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weight[i - 1] <= w)
                    K[i][w] = Math.max(value[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        int maxValue = knapSack(capacity, weight, value, n);
        System.out.println("\nMaximum value that can be put in knapsack = " + maxValue);

        sc.close();
    }
}

