// Program: N-Queens Problem using Backtracking
import java.util.Scanner;
public class NQueens {
    static int N;
    // Function to print the board
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    // Check if a queen can be placed on board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check column on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N Queen problem
    static boolean solveNQUtil(int[][] board, int col) {
        // Base case: If all queens are placed
        if (col >= N)
            return true;

        // Try placing queen in each row of this column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen

                // Recur to place rest of the queens
                if (solveNQUtil(board, col + 1))
                    return true;

                // If placing queen doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }
        return false; // No safe position found
    }

    // Solves the N Queen problem
    static boolean solveNQ(int firstRow) {
        int[][] board = new int[N][N];

        // Place first queen manually
        board[firstRow][0] = 1;

        // Start solving from column 1
        if (!solveNQUtil(board, 1)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N (number of queens): ");
        N = sc.nextInt();

        System.out.print("Enter row number (0-based index) to place first queen: ");
        int firstRow = sc.nextInt();

        System.out.println("\nFinal N-Queens Matrix:");
        solveNQ(firstRow);

        sc.close();
    }
}
