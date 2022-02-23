# Discussion

## PART I: MEASURED IndexedList

1. **Discuss from a design perspective whether or not iterating over a `MeasuredIndexedList` should affect the accesses and mutation counts. Note that for the purposes of this assignment we are NOT asking you to rewrite the `ArrayIndexedListIterator` to do so. However, if you wanted to include the `next()` and/or `hasNext()` methods in the statistics measured, can you inherit `ArrayIndexedListIterator` from `ArrayIndexedList` and override the relevant methods, or not? Explain.**




## PART II: ALL SORT OF SORTS

1. **Explain the mistake in the setup/implementation of the experiment is set up and implemented which resulted in a discrepancy between the results and what is expected from each sorting algorithm.**

`readData()` in `SortingAlgorithmDriver` stores content of data files as a list of Strings. This makes `compareTo()` 
in helper `less()` compare two Strings. `compareTo()` compares Strings lexicographically, for example, `"10".compareTo("9") < 0`. This is not what we
intend to have after sorting.

In addition, in file `descending.data`, some numbers 
 

2. **Does the actual running time correspond to the asymptotic complexity as you would expect?**
   
Sorting over the ascending data is the best-case scenario, and should have zero mutation count.
Sorting over the descending data is the worst-case scenario, and should hav


3. **What explains the practical differences between these algorithms? (Theoretically, the algorithm runs in O(X) time, where X is a function of the input size, but in practice (i.e running it on datasets), you may observe that it is slower/faster compared to the other algorithms)**



4. **Does it matter what kind of data (random, already sorted in ascending order, sorted in descending order) you are sorting? How should each algorithm behave (in terms of performance) based on the type of data it receives?**




## PART III: ANALYSIS OF SELECTION SORT

1. Determine exactly how many comparisons C(n) and assignments A(n) are performed by this implementation of selection sort in the worst case. Both of those should be polynomials of degree 2 since you know that the asymptotic complexity of selection sort is O(n^2).

