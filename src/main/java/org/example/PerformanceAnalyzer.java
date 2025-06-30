package org.example;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PerformanceAnalyzer {

    private static final String CSV_FILE_NAME = "algorithm_performance_data.csv";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("Starting algorithm performance analysis...");

        // Clear previous data or create a new file with header
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_NAME))) {
            writer.println("Algorithm,InputSize,ExecutionTimeNs"); // Use nanoseconds for precision
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
            return;
        }

        // Run analysis for each algorithm
        analyzeCountBinaryDigitsRecursive();
        analyzeCountBinaryDigitsIterative();
        analyzeFactorial();
        analyzeMatrixMultiplication();
        analyzeSequentialSearch();
        analyzeFindMaxElement();
        analyzeHasUniqueElements();
        analyzeGaussianElimination();

        System.out.println("Performance analysis complete. Data saved to " + CSV_FILE_NAME);
    }

    /**
     * Helper method to write performance data to the CSV file.
     * @param algorithmName The name of the algorithm being tested.
     * @param inputSize The size of the input for this test.
     * @param executionTimeNs The execution time in nanoseconds.
     */
    private static void writeToCsv(String algorithmName, long inputSize, long executionTimeNs) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_NAME, true))) { // true for append mode
            writer.println(algorithmName + "," + inputSize + "," + executionTimeNs);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file for " + algorithmName + ": " + e.getMessage());
        }
    }

    /**
     * Generates a random integer array.
     * @param size The size of the array.
     * @param maxVal The maximum value for elements in the array.
     * @return A randomly generated integer array.
     */
    private static int[] generateRandomIntArray(int size, int maxVal) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(maxVal);
        }
        return arr;
    }

    /**
     * Generates a random double array.
     * @param size The size of the array.
     * @param maxVal The maximum value for elements in the array.
     * @return A randomly generated double array.
     */
    private static double[] generateRandomDoubleArray(int size, double maxVal) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextDouble() * maxVal;
        }
        return arr;
    }

    /**
     * Generates a random square double matrix.
     * @param dimension The dimension (N) of the N x N matrix.
     * @param maxVal The maximum value for elements in the matrix.
     * @return A randomly generated square double matrix.
     */
    private static double[][] generateRandomDoubleMatrix(int dimension, double maxVal) {
        double[][] matrix = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = RANDOM.nextDouble() * maxVal;
            }
        }
        return matrix;
    }

    // --- Algorithm Specific Analysis Methods ---

    private static void analyzeCountBinaryDigitsRecursive() {
        String algoName = "countBinaryDigitsRecursive";
        System.out.println("\nAnalyzing " + algoName + "...");
        // Input 'n' for binary digits can go up very high. Use larger steps.
        int[] inputSizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        for (int n : inputSizes) {
            try {
                long startTime = System.nanoTime();
                Algorithms.countBinaryDigitsRecursive(n);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeCountBinaryDigitsIterative() {
        String algoName = "countBinaryDigitsIterative";
        System.out.println("\nAnalyzing " + algoName + "...");
        int[] inputSizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        for (int n : inputSizes) {
            try {
                long startTime = System.nanoTime();
                Algorithms.countBinaryDigits(n);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeFactorial() {
        String algoName = "factorial";
        System.out.println("\nAnalyzing " + algoName + "...");
        // Factorial grows very fast, long can overflow around 20-21!
        int[] inputSizes = {0, 5, 10, 15, 20}; // Max safe for long is 20!
        for (int n : inputSizes) {
            try {
                long startTime = System.nanoTime();
                Algorithms.factorial(n);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeMatrixMultiplication() {
        String algoName = "matrixMultiplication";
        System.out.println("\nAnalyzing " + algoName + "...");
        // O(N^3) algorithm, so N should not be too large
        int[] inputSizes = {5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // N x N matrix
        for (int n : inputSizes) {
            double[][] A = generateRandomDoubleMatrix(n, 100.0);
            double[][] B = generateRandomDoubleMatrix(n, 100.0);
            try {
                long startTime = System.nanoTime();
                Algorithms.multiplyMatrices(A, B);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + "x" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeSequentialSearch() {
        String algoName = "sequentialSearch";
        System.out.println("\nAnalyzing " + algoName + "...");
        // O(N) algorithm
        int[] inputSizes = {1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        for (int n : inputSizes) {
            int[] arr = generateRandomIntArray(n, 10000000);
            int key = -1; // Choose a key that is unlikely to be in the array (worst case)
            try {
                long startTime = System.nanoTime();
                Algorithms.sequentialSearch(arr, key);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeFindMaxElement() {
        String algoName = "findMaxElement";
        System.out.println("\nAnalyzing " + algoName + "...");
        // O(N) algorithm
        int[] inputSizes = {1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        for (int n : inputSizes) {
            double[] arr = generateRandomDoubleArray(n, 1000000.0);
            try {
                long startTime = System.nanoTime();
                Algorithms.findMaxElement(arr);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeHasUniqueElements() {
        String algoName = "hasUniqueElements";
        System.out.println("\nAnalyzing " + algoName + "...");
        // O(N^2) algorithm, so N should not be too large
        int[] inputSizes = {10, 50, 100, 200, 500, 1000, 2000, 3000}; // N^2 complexity, limit N
        for (int n : inputSizes) {
            int[] arr = generateRandomIntArray(n, n * 2); // Ensure some uniqueness but potential duplicates
            try {
                long startTime = System.nanoTime();
                Algorithms.hasUniqueElements(arr);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + ", Time=" + duration + "ns");
            } catch (IllegalArgumentException e) {
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }

    private static void analyzeGaussianElimination() {
        String algoName = "gaussianElimination";
        System.out.println("\nAnalyzing " + algoName + "...");
        // O(N^3) algorithm, N represents the number of rows/equations
        int[] inputSizes = {5, 10, 20, 30, 40, 50, 60, 70, 80}; // N x (N or N+1) matrix
        for (int n : inputSizes) {
            // For Gaussian Elimination analysis, we typically analyze square matrices or N x (N+1) augmented matrices.
            // Let's use N x N for simpler analysis. The actual method can handle N x M.
            double[][] matrix = generateRandomDoubleMatrix(n, 100.0);
            // Deep copy the matrix because Gaussian Elimination modifies the input array
            double[][] matrixCopy = new double[n][];
            for (int i = 0; i < n; i++) {
                matrixCopy[i] = matrix[i].clone();
            }

            try {
                long startTime = System.nanoTime();
                Algorithms.gaussianElimination(matrixCopy); // Use the copy
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                writeToCsv(algoName, n, duration);
                System.out.println("  N=" + n + "x" + n + ", Time=" + duration + "ns");
            } catch (Exception e) { // Catch ArithmeticException for zero pivot, and other potential issues
                System.err.println("  Error for N=" + n + ": " + e.getMessage());
            }
        }
    }
}
