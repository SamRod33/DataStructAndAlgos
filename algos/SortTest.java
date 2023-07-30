import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SortTest {

  public <E> void assertEQ(List<E> one, List<E> two) {
    assertEquals(one.toString(), two.toString());
  }

  public <E> void assertEQ(E[] one, E[] two) {
    assertEquals(Arrays.toString(one), Arrays.toString(two));

  }

  @Test
  public void testExample() {
    assertNotEquals("unexpected", "actual");
    assertFalse(false);
  }

  @Test
  public void testInsertionSort() {
    Integer[] arr = { 9491, 2199, 3752, 454 };
    Integer[] arr1 = {};
    Integer[] arr2 = { 0 };
    String[] arr3 = { "abcd", "acdc" };
    Integer[] arr4 = { 9491, 2, 3752, 454 };
    Integer[] arr4Sorted = { 2, 454, 3752, 9491 };
    List<Integer> l = new ArrayList<>(List.of(9491, 2199, 3752, 454));
    List<Integer> l1 = new ArrayList<>(List.of());
    List<Integer> l2 = new ArrayList<>(List.of(0));
    List<String> l3 = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4 = new ArrayList<>(List.of(9491, 2, 3752, 454));
    List<Integer> lSorted = new ArrayList<>(List.of(454, 2199, 3752, 9491));
    List<Integer> l1Sorted = new ArrayList<>(List.of());
    List<Integer> l2Sorted = new ArrayList<>(List.of(0));
    List<String> l3Sorted = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4Sorted = new ArrayList<>(List.of(2, 454, 3752, 9491));

    // empty array sorted
    assertEquals(Arrays.toString(new Integer[] {}), Arrays.toString(Sort.insertionSort(arr1)));
    // generic array sorted
    assertEquals(Arrays.toString(new Integer[] { 454, 2199, 3752, 9491 }), Arrays.toString(Sort.insertionSort(arr)));
    // one element sorted
    assertEquals(Arrays.toString(new Integer[] { 0 }), Arrays.toString(Sort.insertionSort(arr2)));
    // two elements sorted and strings
    assertEquals(Arrays.toString(new String[] { "abcd", "acdc" }), Arrays.toString(Sort.insertionSort(arr3)));
    assertEQ(arr4Sorted, Sort.insertionSort(arr4));
    assertEQ(lSorted, Sort.insertionSort(l));
    assertEQ(l1Sorted, Sort.insertionSort(l1));
    assertEQ(l2Sorted, Sort.insertionSort(l2));
    assertEQ(l3Sorted, Sort.insertionSort(l3));
    assertEQ(l4Sorted, Sort.insertionSort(l4));
  }

  @Test
  public void testSelectionSort() {
    Integer[] arr = { 9491, 2199, 3752, 454 };
    Integer[] arr1 = {};
    Integer[] arr2 = { 0 };
    String[] arr3 = { "abcd", "acdc" };
    Integer[] arr4 = { 9491, 2, 3752, 454 };
    Integer[] arr4Sorted = { 2, 454, 3752, 9491 };
    List<Integer> l = new ArrayList<>(List.of(9491, 2199, 3752, 454));
    List<Integer> l1 = new ArrayList<>(List.of());
    List<Integer> l2 = new ArrayList<>(List.of(0));
    List<String> l3 = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4 = new ArrayList<>(List.of(9491, 2, 3752, 454));
    List<Integer> lSorted = new ArrayList<>(List.of(454, 2199, 3752, 9491));
    List<Integer> l1Sorted = new ArrayList<>(List.of());
    List<Integer> l2Sorted = new ArrayList<>(List.of(0));
    List<String> l3Sorted = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4Sorted = new ArrayList<>(List.of(2, 454, 3752, 9491));

    assertEquals(Arrays.toString(new Integer[] {}), Arrays.toString(Sort.selectionSort(arr1)));
    assertEquals(Arrays.toString(new Integer[] { 454, 2199, 3752, 9491 }), Arrays.toString(Sort.selectionSort(arr)));
    assertEquals(Arrays.toString(new Integer[] { 0 }), Arrays.toString(Sort.selectionSort(arr2)));
    assertEquals(Arrays.toString(new String[] { "abcd", "acdc" }), Arrays.toString(Sort.selectionSort(arr3)));
    assertEQ(arr4Sorted, Sort.selectionSort(arr4));
    assertEQ(lSorted, Sort.selectionSort(l));
    assertEQ(l1Sorted, Sort.selectionSort(l1));
    assertEQ(l2Sorted, Sort.selectionSort(l2));
    assertEQ(l3Sorted, Sort.selectionSort(l3));
    assertEQ(l4Sorted, Sort.selectionSort(l4));
  }

  @Test
  public void testMergeSort() {
    Integer[] arr = { 9491, 2199, 3752, 454 };
    Sort.mergeSort(arr, 0, arr.length - 1, Integer.class);
    Integer[] arr1 = {};
    Sort.mergeSort(arr1, 0, arr1.length - 1, Integer.class);
    Integer[] arr2 = { 0 };
    Sort.mergeSort(arr2, 0, arr2.length - 1, Integer.class);
    String[] arr3 = { "abcd", "acdc" };
    Sort.mergeSort(arr3, 0, arr3.length - 1, String.class);
    Integer[] arr4 = { 9491, 2, 3752, 454 };
    Sort.mergeSort(arr4, 0, arr4.length - 1, Integer.class);
    Integer[] arr4Sorted = { 2, 454, 3752, 9491 };
    List<Integer> l = new ArrayList<>(List.of(9491, 2199, 3752, 454));
    List<Integer> l1 = new ArrayList<>(List.of());
    List<Integer> l2 = new ArrayList<>(List.of(0));
    List<String> l3 = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4 = new ArrayList<>(List.of(9491, 2, 3752, 454));
    List<Integer> lSorted = new ArrayList<>(List.of(454, 2199, 3752, 9491));
    List<Integer> l1Sorted = new ArrayList<>(List.of());
    List<Integer> l2Sorted = new ArrayList<>(List.of(0));
    List<String> l3Sorted = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4Sorted = new ArrayList<>(List.of(2, 454, 3752, 9491));
    Sort.mergeSort(l, 0, l.size() - 1);
    Sort.mergeSort(l1, 0, l1.size() - 1);
    Sort.mergeSort(l2, 0, l2.size() - 1);
    Sort.mergeSort(l3, 0, l3.size() - 1);
    Sort.mergeSort(l4, 0, l4.size() - 1);

    assertEquals(Arrays.toString(new Integer[] {}), Arrays.toString(arr1));
    assertEquals(Arrays.toString(new Integer[] { 454, 2199, 3752, 9491 }), Arrays.toString(arr));
    assertEquals(Arrays.toString(new Integer[] { 0 }), Arrays.toString(arr2));
    assertEquals(Arrays.toString(new String[] { "abcd", "acdc" }), Arrays.toString(arr3));
    assertEQ(arr4Sorted, arr4);
    assertEQ(lSorted, l);
    assertEQ(l1Sorted, l1);
    assertEQ(l2Sorted, l2);
    assertEQ(l3Sorted, l3);
    assertEQ(l4Sorted, l4);
  }

  @Test
  public void testQuickSort() {
    Integer[] arr = { 9491, 2199, 3752, 454 };
    Sort.quickSort(arr, 0, arr.length - 1);
    Integer[] arr1 = {};
    Sort.quickSort(arr1, 0, arr1.length - 1);
    Integer[] arr2 = { 0 };
    Sort.quickSort(arr2, 0, arr2.length - 1);
    String[] arr3 = { "abcd", "acdc" };
    Sort.quickSort(arr3, 0, arr3.length - 1);
    Integer[] arr4 = { 9491, 2, 3752, 454 };
    Sort.quickSort(arr4, 0, arr4.length - 1);
    Integer[] arr4Sorted = { 2, 454, 3752, 9491 };
    List<Integer> l = new ArrayList<>(List.of(9491, 2199, 3752, 454));
    List<Integer> l1 = new ArrayList<>(List.of());
    List<Integer> l2 = new ArrayList<>(List.of(0));
    List<String> l3 = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4 = new ArrayList<>(List.of(9491, 2, 3752, 454));
    List<Integer> lSorted = new ArrayList<>(List.of(454, 2199, 3752, 9491));
    List<Integer> l1Sorted = new ArrayList<>(List.of());
    List<Integer> l2Sorted = new ArrayList<>(List.of(0));
    List<String> l3Sorted = new ArrayList<>(List.of("abcd", "acdc"));
    List<Integer> l4Sorted = new ArrayList<>(List.of(2, 454, 3752, 9491));
    Sort.quickSort(l, 0, l.size() - 1);
    Sort.quickSort(l1, 0, l1.size() - 1);
    Sort.quickSort(l2, 0, l2.size() - 1);
    Sort.quickSort(l3, 0, l3.size() - 1);
    Sort.quickSort(l4, 0, l4.size() - 1);

    assertEquals(Arrays.toString(new Integer[] {}), Arrays.toString(arr1));
    assertEquals(Arrays.toString(new Integer[] { 454, 2199, 3752, 9491 }), Arrays.toString(arr));
    assertEquals(Arrays.toString(new Integer[] { 0 }), Arrays.toString(arr2));
    assertEquals(Arrays.toString(new String[] { "abcd", "acdc" }), Arrays.toString(arr3));
    assertEQ(arr4Sorted, arr4);
    assertEQ(lSorted, l);
    assertEQ(l1Sorted, l1);
    assertEQ(l2Sorted, l2);
    assertEQ(l3Sorted, l3);
    assertEQ(l4Sorted, l4);
  }

}