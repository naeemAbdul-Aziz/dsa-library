package org.example;

public class Algorithms {

    public static int countBinaryDigitsRecursive(int n) {
        if (n <= 0) throw new IllegalArgumentException("Positive input only.");
        if (n == 1) { return 1; } else { return countBinaryDigitsRecursive(n / 2) + 1; }
    }

    public static int countBinaryDigits(int n) {
        if (n <= 0) throw new IllegalArgumentException("Positive input only.");
        int count = 1;
        while (n > 1) { count++; n = n / 2; }
        return count;
    }

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Non-negative input only.");
        if (n == 0) { return 1; } else { return factorial(n - 1) * n; }
    }

    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        // Ensure matrices are compatible for multiplication.
        // For simplicity, assuming square matrices of same dimension for this example.
        if (A.length != A[0].length || B.length != B[0].length || A[0].length != B.length) {
            throw new IllegalArgumentException("Matrices must be square and compatible for multiplication (A.cols == B.rows).");
        }
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0.0;
                for (int k = 0; k < n; k++) { C[i][j] += A[i][k] * B[k][j]; }
            }
        }
        return C;
    }

    public static int sequentialSearch(int[] A, int K) {
        if (A == null) throw new IllegalArgumentException("Array cannot be null.");
        int i = 0;
        while (i < A.length && A[i] != K) { i++; }
        return (i < A.length) ? i : -1;
    }

    public static double findMaxElement(double[] A) {
        if (A == null || A.length == 0) throw new IllegalArgumentException("Empty list.");
        double maxval = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > maxval) { maxval = A[i]; }
        }
        return maxval;
    }

    public static boolean hasUniqueElements(int[] A) {
        if (A == null) throw new IllegalArgumentException("Array cannot be null.");
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) { return false; }
            }
        }
        return true;
    }

    public static void gaussianElimination(double[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            System.out.println("Matrix is empty or null. No operation performed.");
            return;
        }
        int n = A.length;
        int m = A[0].length; // number of columns (n equations, m variables/augmented columns)

        // For simplicity, this implementation assumes a square matrix for pivots and
        // does not include full pivoting strategies (row swapping for non-zero pivots).
        // A robust Gaussian elimination would need to handle zero pivots by swapping rows.
        if (n > m) {
            System.out.println("Warning: More rows than columns, may not be solvable with basic Gaussian elimination.");
        }

        for (int i = 0; i < n; i++) { // For each pivot row
            // Find pivot (largest absolute value in the current column below or at current row)
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Swap max row with current row
            double[] temp = A[i];
            A[i] = A[maxRow];
            A[maxRow] = temp;

            // Check if pivot is zero after potential swapping
            if (A[i][i] == 0.0) {
                System.out.println("Warning: Zero pivot encountered at row " + i + ", column " + i + ". Matrix may be singular or solution may not be unique/exist.");
                // For a more complete solution, you might return false, throw an exception,
                // or handle free variables. For this basic example, we will just proceed.
                continue; // Skip elimination for this row if pivot is zero
            }

            // Eliminate column i below current row
            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                for (int k = i; k < m; k++) {
                    A[j][k] -= A[i][k] * factor;
                }
            }
        }
    }
}
