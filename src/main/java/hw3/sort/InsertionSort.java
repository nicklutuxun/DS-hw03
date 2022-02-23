package hw3.sort;


import hw3.list.IndexedList;

/**
 * The Insertion Sort algorithm, with minimizing swaps optimization.
 *
 * @param <T> Element type.
 */
public final class InsertionSort<T extends Comparable<T>>
    implements SortingAlgorithm<T> {

  @Override
  public void sort(IndexedList<T> indexedList) {
    int i = 1;
    while (i < indexedList.length()) {
      T cur = indexedList.get(i);
      int j = i - 1;
      while (j >= 0 && indexedList.get(j).compareTo(cur) > 0) {
        indexedList.put(j + 1, indexedList.get(j));
        j--;
      }
      indexedList.put(j + 1, cur);
      i++;
    }
  }

  @Override
  public String name() {
    return "Insertion Sort";
  }
}
