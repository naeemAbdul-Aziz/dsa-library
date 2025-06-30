package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner; // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Welcome to the Algorithm Explorer!");

        // --- Test countBinaryDigitsRecursive ---
        System.out.println("\n--- Recursive Count Binary Digits ---");
        System.out.print("Enter a positive integer (for recursive binary digit count): ");
        try {
            int nRecursiveBinary = scanner.nextInt();
            int result = Algorithms.countBinaryDigitsRecursive(nRecursiveBinary);
            System.out.println("Binary digits in " + nRecursiveBinary + ": " + result);
            System.out.println("Time Complexity: O(log n)");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test countBinaryDigits (Iterative) ---
        System.out.println("\n--- Iterative Count Binary Digits ---");
        System.out.print("Enter a positive integer (for iterative binary digit count): ");
        try {
            int nIterativeBinary = scanner.nextInt();
            int result = Algorithms.countBinaryDigits(nIterativeBinary);
            System.out.println("Binary digits in " + nIterativeBinary + ": " + result);
            System.out.println("Time Complexity: O(log n)");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test RecursiveFactorial ---
        System.out.println("\n--- Recursive Factorial ---");
        System.out.print("Enter a non-negative integer (for factorial): ");
        try {
            int nFactorial = scanner.nextInt();
            long result = Algorithms.factorial(nFactorial);
            System.out.println("Factorial of " + nFactorial + ": " + result);
            System.out.println("Time Complexity: O(n)");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test MatrixMultiplication ---
        System.out.println("\n--- Matrix Multiplication ---");
        System.out.print("Enter the dimension N for N x N matrices (e.g., 2 for 2x2): ");
        try {
            int dim = scanner.nextInt();
            if (dim <= 0) {
                System.out.println("Error: Dimension must be positive.");
            } else {
                double[][] A = new double[dim][dim];
                double[][] B = new double[dim][dim];

                System.out.println("Enter elements for Matrix A (" + dim + "x" + dim + "):");
                for (int i = 0; i < dim; i++) {
                    for (int j = 0; j < dim; j++) {
                        System.out.print("A[" + i + "][" + j + "]: ");
                        A[i][j] = scanner.nextDouble();
                    }
                }

                System.out.println("Enter elements for Matrix B (" + dim + "x" + dim + "):");
                for (int i = 0; i < dim; i++) {
                    for (int j = 0; j < dim; j++) {
                        System.out.print("B[" + i + "][" + j + "]: ");
                        B[i][j] = scanner.nextDouble();
                    }
                }

                double[][] C = Algorithms.multiplyMatrices(A, B);
                System.out.println("Result of matrix multiplication:");
                for (double[] row : C) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("Time Complexity: O(N^3)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers for matrix elements.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test SequentialSearch ---
        System.out.println("\n--- Sequential Search ---");
        System.out.print("Enter the size of the array: ");
        try {
            int arraySize = scanner.nextInt();
            if (arraySize <= 0) {
                System.out.println("Error: Array size must be positive.");
            } else {
                int[] arr = new int[arraySize];
                System.out.println("Enter " + arraySize + " integer elements for the array:");
                for (int i = 0; i < arraySize; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                }

                System.out.print("Enter the key to search for: ");
                int searchKey = scanner.nextInt();

                int index = Algorithms.sequentialSearch(arr, searchKey);
                if (index != -1) {
                    System.out.println("Key " + searchKey + " found at index: " + index);
                } else {
                    System.out.println("Key " + searchKey + " not found in the array.");
                }
                System.out.println("Time Complexity: O(N) (Worst Case)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test MaxElement ---
        System.out.println("\n--- Find Max Element ---");
        System.out.print("Enter the size of the double array: ");
        try {
            int doubleArraySize = scanner.nextInt();
            if (doubleArraySize <= 0) {
                System.out.println("Error: Array size must be positive.");
            } else {
                double[] doubleArr = new double[doubleArraySize];
                System.out.println("Enter " + doubleArraySize + " double elements for the array:");
                for (int i = 0; i < doubleArraySize; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    doubleArr[i] = scanner.nextDouble();
                }

                double maxVal = Algorithms.findMaxElement(doubleArr);
                System.out.println("Max element: " + maxVal);
                System.out.println("Time Complexity: O(N)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test UniqueElement ---
        System.out.println("\n--- Has Unique Elements ---");
        System.out.print("Enter the size of the integer array: ");
        try {
            int uniqueArraySize = scanner.nextInt();
            if (uniqueArraySize <= 0) {
                System.out.println("Error: Array size must be positive.");
            } else {
                int[] uniqueCheckArr = new int[uniqueArraySize];
                System.out.println("Enter " + uniqueArraySize + " integer elements for the array:");
                for (int i = 0; i < uniqueArraySize; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    uniqueCheckArr[i] = scanner.nextInt();
                }

                boolean isUnique = Algorithms.hasUniqueElements(uniqueCheckArr);
                System.out.println("Has unique elements: " + isUnique);
                System.out.println("Time Complexity: O(N^2)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers.");
            scanner.next(); // Consume the invalid input
        }

        // --- Test GaussianElimination ---
        System.out.println("\n--- Gaussian Elimination ---");
        System.out.print("Enter the number of rows (N) for the matrix: ");
        try {
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns (M) for the matrix (N for square, N+1 for augmented): ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Error: Matrix dimensions must be positive.");
            } else {
                double[][] gaussianMatrix = new double[rows][cols];
                System.out.println("Enter elements for the " + rows + "x" + cols + " matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Matrix[" + i + "][" + j + "]: ");
                        gaussianMatrix[i][j] = scanner.nextDouble();
                    }
                }

                System.out.println("Original Matrix:");
                for (double[] row : gaussianMatrix) {
                    System.out.println(Arrays.toString(row));
                }

                Algorithms.gaussianElimination(gaussianMatrix);

                System.out.println("Matrix after Gaussian Elimination:");
                for (double[] row : gaussianMatrix) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("Time Complexity: O(N^3) (where N is the number of rows)");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers for matrix dimensions and elements.");
            scanner.next(); // Consume the invalid input
        } catch (Exception e) { // Catch any other exceptions from Gaussian Elimination
            System.out.println("An error occurred during Gaussian Elimination: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner to prevent resource leaks
        }
        System.out.println("\nAlgorithm exploration complete!");
    }
}
