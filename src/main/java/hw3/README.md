# Discussion

## PART I: MEASURED IndexedList

1. **Discuss from a design perspective whether or not iterating over a `MeasuredIndexedList` should affect the accesses and mutation counts. Note that for the purposes of this assignment we are NOT asking you to rewrite the `ArrayIndexedListIterator` to do so. However, if you wanted to include the `next()` and/or `hasNext()` methods in the statistics measured, can you inherit `ArrayIndexedListIterator` from `ArrayIndexedList` and override the relevant methods, or not? Explain.**

Iterating over a `MeasuredIndexedList` will have access to each and every element in the list, so it should add to the accesses count. 
However, iterating through the list does not modify any of the element value so mutation count is unchanged. 

We can't inherit `ArrayIndexedListIterator` from `ArrayIndexedList` because it is a private nested class inside `ArrayIndexedList`
which is only visible within the `ArrayIndexedList` class. Therefore, we do not have access to `ArrayIndexedListIterator` and thus cannot
inherit from it.

## PART II: ALL SORT OF SORTS

1. **Explain the mistake in the setup/implementation of the experiment is set up and implemented which resulted in a discrepancy between the results and what is expected from each sorting algorithm.**

`readData()` in `SortingAlgorithmDriver` stores content of data files as a list of Strings. This makes `compareTo()` 
in helper `less()` compare two Strings. `compareTo()` compares Strings lexicographically, for example, `"10".compareTo("9") < 0`. This is not what we
intend to have after sorting.

In addition, in file `descending.data`, some numbers are missing the last digits, which makes the file 
not strictly descending.

2. **Does the actual running time correspond to the asymptotic complexity as you would expect?**

To check the time complexity of algorithms, I run each algorithm with different input size, I choose
`descending.data` because it simulates the worst-case scenario:

| Size        | 100      | 500      | 1000     | 2000     | 4000     | 8000     |
|-------------|----------|----------|----------|----------|----------|----------|
| `Gnome`     | 0.007479 | 0.008003 | 0.014151 | 0.036708 | 0.124228 | 0.400003 |
| `Selection` | 0.000595 | 0.005128 | 0.004413 | 0.011103 | 0.038343 | 0.145048 |
| `Bubble`    | 0.001571 | 0.005547 | 0.009721 | 0.013692 | 0.049715 | 0.196066 |
| `Insertion` | 0.000391 | 0.009940 | 0.009741 | 0.016389 | 0.058313 | 0.160022 |

<iframe src="https://www.desmos.com/calculator/w5mt0esddt?embed" width="500" height="500" style="border: 1px solid #ccc" frameborder=0></iframe>

3. **What explains the practical differences between these algorithms? (Theoretically, the algorithm runs in O(X) time, where X is a function of the input size, but in practice (i.e running it on datasets), you may observe that it is slower/faster compared to the other algorithms)**



4. **Does it matter what kind of data (random, already sorted in ascending order, sorted in descending order) you are sorting? How should each algorithm behave (in terms of performance) based on the type of data it receives?**




## PART III: ANALYSIS OF SELECTION SORT

1. Determine exactly how many comparisons C(n) and assignments A(n) are performed by this implementation of selection sort in the worst case. Both of those should be polynomials of degree 2 since you know that the asymptotic complexity of selection sort is O(n^2).

