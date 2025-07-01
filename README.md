# Data Structures & Algorithms Library 

A comprehensive Java library implementing fundamental algorithms and data structure operations. This project demonstrates proficiency in algorithmic thinking, time complexity analysis, and clean code practices.

## Features

This library includes implementations of essential algorithms across different categories:

- **Recursive Algorithms**: Binary digit counting, factorial computation
- **Array Operations**: Sequential search, maximum element finding, uniqueness checking
- **Matrix Operations**: Matrix multiplication, Gaussian elimination
- **Mathematical Computations**: Factorial, binary representations

## Algorithm Implementations

### 1. Binary Digit Counter
**Files**: `countBinaryDigitsRecursive()`, `countBinaryDigits()`
- **Purpose**: Count the number of binary digits in a positive integer
- **Implementations**: Both recursive and iterative approaches
- **Time Complexity**: O(log n)
- **Space Complexity**: O(log n) recursive, O(1) iterative

```java
int digits = Algorithms.countBinaryDigitsRecursive(15); // Returns 4 (1111 in binary)
```

### 2. Factorial Calculator
**File**: `factorial()`
- **Purpose**: Compute factorial of non-negative integers using recursion
- **Time Complexity**: O(n)
- **Space Complexity**: O(n) due to call stack

```java
long result = Algorithms.factorial(5); // Returns 120
```

### 3. Matrix Multiplication
**File**: `multiplyMatrices()`
- **Purpose**: Multiply two square matrices using standard algorithm
- **Time Complexity**: O(n³)
- **Space Complexity**: O(n²)
- **Features**: Input validation for matrix compatibility

```java
double[][] result = Algorithms.multiplyMatrices(matrixA, matrixB);
```

### 4. Sequential Search
**File**: `sequentialSearch()`
- **Purpose**: Linear search through integer array
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Returns**: Index of found element or -1 if not found

```java
int index = Algorithms.sequentialSearch(array, targetValue);
```

### 5. Maximum Element Finder
**File**: `findMaxElement()`
- **Purpose**: Find the largest element in a double array
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

```java
double max = Algorithms.findMaxElement(doubleArray);
```

### 6. Unique Elements Checker
**File**: `hasUniqueElements()`
- **Purpose**: Determine if all array elements are unique
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Returns**: Boolean indicating uniqueness

```java
boolean isUnique = Algorithms.hasUniqueElements(intArray);
```

### 7. Gaussian Elimination
**File**: `gaussianElimination()`
- **Purpose**: Perform Gaussian elimination on a matrix for solving linear systems
- **Time Complexity**: O(n³)
- **Space Complexity**: O(1) additional space
- **Features**: Partial pivoting, singular matrix detection

```java
Algorithms.gaussianElimination(augmentedMatrix); // Modifies matrix in-place
```

## Usage

### Prerequisites
- Java 8 or higher
- IDE of choice (IntelliJ IDEA, Eclipse, VS Code)

### Running the Interactive Demo

The `Main.java` file provides an interactive command-line interface to test all algorithms:

```bash
javac org/example/*.java
java org.example.Main
```

The program will guide you through testing each algorithm with custom inputs and display:
- Algorithm results
- Time complexity information
- Error handling for invalid inputs

### Integration into Your Projects

```java
import org.example.Algorithms;

// Use any algorithm directly
int binaryDigits = Algorithms.countBinaryDigits(42);
double max = Algorithms.findMaxElement(myArray);
```

## Testing Features

The interactive main class includes comprehensive testing for:
- **Input Validation**: Handles negative numbers, null arrays, empty inputs
- **Error Handling**: Graceful handling of `IllegalArgumentException` and `InputMismatchException`
- **Edge Cases**: Zero values, single elements, large numbers
- **User Experience**: Clear prompts and informative output

## Time Complexity Summary

| Algorithm | Best Case | Average Case | Worst Case | Space |
|-----------|-----------|--------------|------------|-------|
| Binary Digit Count | O(log n) | O(log n) | O(log n) | O(1) |
| Factorial | O(n) | O(n) | O(n) | O(n) |
| Matrix Multiplication | O(n³) | O(n³) | O(n³) | O(n²) |
| Sequential Search | O(1) | O(n) | O(n) | O(1) |
| Find Maximum | O(n) | O(n) | O(n) | O(1) |
| Unique Elements | O(n) | O(n²) | O(n²) | O(1) |
| Gaussian Elimination | O(n³) | O(n³) | O(n³) | O(1) |

## Learning Objectives Demonstrated

This project showcases understanding of:
- **Algorithm Design**: Recursive vs iterative approaches
- **Time/Space Complexity Analysis**: Big O notation implementation
- **Error Handling**: Robust input validation and exception management
- **Code Organization**: Clean separation of algorithms and testing logic
- **Documentation**: Comprehensive comments and user guidance
- **Mathematical Algorithms**: Linear algebra and number theory applications

## Future Enhancements

Potential improvements and additions:
- **Sorting Algorithms**: QuickSort, MergeSort, HeapSort implementations
- **Graph Algorithms**: BFS, DFS, Dijkstra's algorithm
- **Dynamic Programming**: Fibonacci, knapsack problem solutions
- **Advanced Data Structures**: Binary trees, hash tables, heaps
- **Performance Benchmarking**: Timing comparisons between algorithms
- **Unit Testing**: JUnit test suite for automated testing

## Notes

- All algorithms include proper input validation and error handling
- Matrix operations assume square matrices for simplicity
- Gaussian elimination includes basic pivoting but could be enhanced with full pivoting
- The library prioritizes educational clarity over maximum optimization

## About

This library was developed as part of computer science coursework to demonstrate proficiency in:
- Algorithm implementation and analysis
- Java programming best practices
- Problem-solving and computational thinking
- Software engineering principles


---

*Feel free to explore, test, and build upon these implementations.*
