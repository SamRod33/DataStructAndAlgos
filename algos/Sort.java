import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

  /** Swaps elements at indices i and j in arr */
  public static <E> void swap(E[] arr, int i, int j) {
    E temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static <E> void swap(List<E> arr, int i, int j) {
    E temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  /** Returns a sorted array using insertion sort. */
  public static <E extends Comparable<E>> E[] insertionSort(E[] arr) {
    // given arr[0 .. arr.length - 1]
    // inv: elements arr[0 .. i-1] are sorted
    for (int i = 0; i < arr.length; i++) {
      int k = i;
      while (k > 0 && arr[k].compareTo(arr[k - 1]) < 0) {
        swap(arr, k - 1, k);
        k--;
      }
    }
    return arr;
  }

  /** Returns a sorted array using selection sort. */
  public static <E extends Comparable<E>> E[] selectionSort(E[] arr) {
    // given arr[0 .. arr.length - 1]
    // inv: elements arr[0 .. i-1] are sorted
    // and arr[0..i-1] <= arr[i..arr.length-1]
    for (int i = 0; i < arr.length; i++) {
      int k = i; // k : min element from arr[i..arr.length-1]
      for (int j = i; j < arr.length; j++) {
        if (arr[j].compareTo(arr[k]) < 0)
          k = j;
      }
      swap(arr, k, i);

    }
    return arr;
  }

  /** Modifies arr in its region from arr[h..t] using merge sort. */
  public static <E extends Comparable<E>> void mergeSort(E[] arr, int h, int t, Class<E> clazz) {
    // if there is less than 2 elements (Base Case)
    if (t - h < 1)
      return;
    int k = (h + t) / 2;
    mergeSort(arr, h, k, clazz); // merge
    mergeSort(arr, k + 1, t, clazz);
    merge(arr, h, k, t, clazz);
  }

  /** Sorts arr[h..t]. Precondition: arr[h..k] and arr[k+1..t] is sorted. */
  public static <E extends Comparable<E>> void merge(E[] arr, int h, int k, int t, Class<E> clazz) {
    E[] mini = (E[]) Array.newInstance(clazz, k - h + 1);
    // copy arr[h..k] to mini
    for (int i = 0; i < k - h + 1; i++) {
      mini[i] = arr[i + h];
    }
    int u = 0;
    int i = h;
    int v = k + 1;
    while (u <= k - h) {
      if (v <= t && arr[v].compareTo(mini[u]) < 0) {
        arr[i] = arr[v];
        v++;
      } else {
        arr[i] = mini[u];
        u++;
      }
      i++;
    }

  }

  /** Sorts arr[h..t] using quick sort. */
  public static <E extends Comparable<E>> void quickSort(E[] arr, int h, int t) {
    // if there is fewer than 2 elements, base case
    if (t - h < 1)
      return;
    int j = partition(arr, h, t);
    quickSort(arr, h, j - 1);
    quickSort(arr, j + 1, t);
  }

  /**
   * Returns index of median element. Modifies arr[h..t] such that arr[h..j-1] <=
   * arr[j] <= arr[j+1..t]
   */
  public static <E extends Comparable<E>> int partition(E[] arr, int h, int t) {
    int j = h;
    int k = t;
    while (j < k) {
      // if arr[j] is greater than or equal to arr[j+1], swap them and increase j
      if (arr[j].compareTo(arr[j + 1]) >= 0) {
        swap(arr, j, j + 1);
        j++;
      }
      // otherwise, swap arr[j+1] with arr[k] and decrease k
      else {
        swap(arr, j + 1, k);
        k--;
      }
    }

    return j;
  }

  /** Returns a sorted List using insertion sort. */
  public static <E extends Comparable<E>> List<E> insertionSort(List<E> arr) {
    // pre: unsorted list, arr[0..arr.length-1]
    // post: sorted list, arr[0..arr.length-1]
    // inv: arr[0..i-1] sorted, arr[i..] unsorted
    int i = 0;
    while (i < arr.size()) {
      int k = i;
      while (k > 0 && arr.get(k).compareTo(arr.get(k - 1)) < 0) {
        swap(arr, k, k - 1);
        k--;
      }
      i++;
    }
    return arr;
  }

  /** Returns a sorted List using selection sort. */
  public static <E extends Comparable<E>> List<E> selectionSort(List<E> arr) {
    // invariant: arr[0..i-1] is sorted and arr[0..i-1] <= arr[i..]
    int i = 0;
    while (i < arr.size()) {
      int min = i;
      int j = i;
      while (j < arr.size()) {
        if (arr.get(min).compareTo(arr.get(j)) > 0) {
          min = j;
        }
        j++;
      }
      swap(arr, i, min);
      i++;
    }
    return arr;
  }

  /** Sorts List using merge sort. */
  public static <E extends Comparable<E>> void mergeSort(List<E> arr, int h, int t) {
    if (t - h < 1)
      return;
    int k = (h + t) / 2 + 1;
    mergeSort(arr, h, k - 1);
    mergeSort(arr, k, t);
    merge(arr, h, k, t);
  }

  public static <E extends Comparable<E>> void merge(List<E> arr, int h, int k, int t) {
    List<E> ss1 = new ArrayList<>();
    for (int c = h; c < k; c++) {
      ss1.add(arr.get(c));
    }
    int u = 0;
    int i = h;
    int v = k;

    while (u < k - h) {
      if (v <= t && arr.get(v).compareTo(ss1.get(u)) < 0) {
        arr.set(i, arr.get(v));
        v++;
      } else {
        arr.set(i, ss1.get(u));
        u++;
      }
      i++;
    }
  }

  /** Sorts List using quick sort. */
  public static <E extends Comparable<E>> void quickSort(List<E> arr, int h, int t) {
    if (t - h < 1)
      return;
    int j = partition(arr, h, t);
    quickSort(arr, h, j - 1);
    quickSort(arr, j + 1, t);

  }

  public static <E extends Comparable<E>> int partition(List<E> arr, int h, int t) {
    int j = h;
    int k = t;
    while (j < k) {
      if (arr.get(j).compareTo(arr.get(j + 1)) >= 0) {
        swap(arr, j, j + 1);
        j++;
      } else {
        swap(arr, j + 1, k);
        k--;
      }
    }
    return j;
  }

}
