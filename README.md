# Project 1

## Code Description

### QuickSort.java

This file contains the QuickSort interface with two main methods: sort(arr) and getCount()

### RandomQuickSort.java and DeterministicQuickSort.java

This former contains RandomQuickSort class which implements QuickSort interface.
The same interface is implemented by DeterministicQuicksort class in the DeterministicQuickSort.java file.

### ImprovedQuickSort.java

This file contains a class that attempts to improve the performance of the quicksort algorithm by sometimes choosing the partition elements randomly, and sometimes deterministically.

### Tester.java
 This file contains all of the testing code. There are four primary methods in this file:

```
private static long averageRuntime(QuickSort sorter, int input_size, String input_type)
```

This method returns the average runtime of a sorter for a specific input size

```
private static void testAverageRuntimes()
```

This method just makes use of the averageRuntime(...) method

```
private static double variance(QuickSort sorter, int input_size, String input_type) 
```
 This calculates the variance and prints it, but then also *returns* the squared coefficient of variation for a specific sorter, input size, and input type

```
private static void testImprovedQS()
```

This method just uses averageRuntime(...) method to test the ImprovedQuickSort

## Running the Code

First one needs to compile the code:
```
$ javac *.java
```

then to run the Tester
```
$ java Tester
```

Following this, results will start to appear on the console, in the following order and format:

```
Average runtime for [input type] input
[RandSorter - i.e. RandomQuickSort]
[n] :: [runtime]
[n] :: [runtime]
...
[DetSorter - i.e. DeterministicQuickSort]
[n] :: [runtime]
[n] :: [runtime]
...
```

This will be printed for every type of input. Then, the average runtimes of the ImprovedQuickSort will be printed for every type of input as follows

```
Average runtime for random input
Improved QuickSort
[n] :: [runtime]
[n] :: [runtime]
...
Average runtime for p_sorted input
Improved QuickSort
[n] :: [runtime]
[n] :: [runtime]
...
Average runtime for m_sorted input
Improved QuickSort
[n] :: [runtime]
[n] :: [runtime]
...
```

And finally the terminal will show the variance and squared coefficient of variation values for all possible configurations:

```
[variance for randsorter with n = 500000 for random input];
[squared coefficient of variation for randsorter with n = 500000 for random input];

[variance for detsorter with n = 500000 for random input];
[squared coefficient of variation for detsorter with n = 500000 for random input];

[variance for randsorter with n = 100000 for partially sorted input];
[squared coefficient of variation for randsorter with n = 100000 for partially sorted input];

[variance for detsorter with n = 100000 for partially sorted input];
[squared coefficient of variation for detsorter with n = 100000 for partially sorted input];

[variance for randsorter with n = 10000 for mostly sorted input];
[squared coefficient of variation for randsorter with n = 10000 for mostly sorted input];

[variance for detsorter with n = 10000 for mostly sorted input];
[squared coefficient of variation for detsorter with n = 10000 for mostly sorted input];
```