package tepigmc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
  /**
   * Converts a List to an array
   * @param list the List to convert
   * @return the resulting array
   */
  public static <T> List<T> toList(T[] array) {
    List<T> list = new ArrayList<T>();
    for (T item : array)
      list.add(item);
    return list;
  }

  /**
   * Converts a 2D array to a 2D List
   * @param array the 2D array to convert
   * @return the resulting 2D List
   */
  public static <T> List<List<T>> toList2D(T[][] array) {
    List<List<T>> list = new ArrayList<List<T>>();
    for (T[] row : array)
      list.add(toList(row));
    return list;
  }

  /**
   * Converts a String array into a 2D char array with even widths
   * @param stringArray
   * @return
   */
  public static char[][] toCharArray2D(String[] stringArray) {
    // Calculate the width of the longest string
    int width = 0;
    int height = stringArray.length;
    for (String row : stringArray) {
      int length = row.length();
      if (width < length)
        width = length;
    }
    // Convert the String array into a 2D char array
    char[][] charArray = new char[height][width];
    for (int i = 0; i < height; i++) {
      char[] row = stringArray[i].toCharArray();
      if (row.length != width)
        row = Arrays.copyOf(row, width);
      charArray[i] = row;
    }
    return charArray;
  }

  /**
   * Creates an array containing the items between the specified fromIndex,
   * inclusive, and toIndex, exclusive.
   * @param array the array to split
   * @param fromIndex minimum index, inclusive
   * @param toIndex maximum index, exclusive
   * @return the sub array of included items
   */
  public static <T> T[] subArray(T[] array, int fromIndex, int toIndex)
      throws IndexOutOfBoundsException, IllegalArgumentException {
    if (toIndex > array.length)
      throw new IndexOutOfBoundsException("toIndex > array.length; toIndex: "
          + toIndex + ", length: " + array.length);
    if (fromIndex >= toIndex)
      throw new IllegalArgumentException("fromIndex >= toIndex; fromIndex: "
          + fromIndex + ", toIndex: " + toIndex);
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[toIndex - fromIndex];
    int resultIndex = 0;
    for (int i = fromIndex; i < toIndex; i++) {
      result[resultIndex] = array[i];
      resultIndex++;
    }
    return result;
  }

  /**
   * Creates an array containing the items between the specified fromIndex,
   * inclusive, and the length, exclusive.
   * @param array the array to split
   * @return the sub array of included items
   */
  public static <T> T[] subArray(T[] array, int startIndex) {
    return subArray(array, startIndex, array.length);
  }

  /**
   * Merges two arrays
   * @param arrayA the array to merge before arrayB
   * @param arrayB the array to merge after arrayA
   * @return the result of the merge
   */
  public static <T> T[] merge(T[] arrayA, T[] arrayB) {
    int lengthA = arrayA.length, lengthB = arrayB.length;
    T[] merged = Arrays.copyOf(arrayA, lengthA + lengthB);
    for (int i = 0; i < lengthB; i++) {
      merged[i + lengthA] = arrayB[i];
    }
    return merged;
  }

  /**
   * Creates a new array with all the elements set to the given value
   * @param length the amount of items in the new array
   * @param value the value to fill the new array with
   * @return the filled array
   */
  public static <T> T[] fill(int length, T value) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[length];
    for (int i = 0; i < length; i++)
      array[i] = value;
    return array;
  }

  /**
   * Creates a new 2D array with all the elements set to the given value
   * @param rows the amount of rows in the new 2D array
   * @param cols the amount of columns in the new 2D array
   * @param value the value to fill the new 2D array with
   * @return the filled 2D array
   */
  @SuppressWarnings("unchecked")
  public static <T> T[][] fill2D(int rows, int cols, T value) {
    T[][] array = (T[][]) new Object[rows][cols];
    for (int r = 0; r < rows; r++) {
      T[] row = (T[]) new Object[cols];
      for (int c = 0; c < cols; c++)
        row[c] = value;
      array[r] = row;
    }
    return array;
  }

  /**
   * Creates a String representation of the array
   * @param array to create the String from
   * @return the String representation of the array
   */
  public static <T> String toString(T[] array) {
    if (array == null)
      return "null";
    String arrayString = "[";
    int length = array.length;
    for (int i = 0; i < length; i++)
      arrayString += array[i] + (i < length - 1 ? ", " : "");
    return arrayString + "]";
  }

  /**
   * Creates a String representation of the array
   * @param array to create the String from
   * @return the String representation of the array
   */
  public static <T> String toString2D(T[][] array) {
    if (array == null)
      return "null";
    String arrayString = "[";
    int rows = array.length;
    for (int r = 0; r < rows; r++)
      arrayString += toString(array[r]) + (r < rows - 1 ? ", " : "]");
    return arrayString;
  }

  /**
   * Returns the index where the target is found, -1 if not found
   * @param target the item to search for
   * @return the index where the target is located or -1
   */
  public static <T> int indexOf(T[] array, T target) {
    for (int i = 0; i < array.length; i++) {
      T item = array[i];
      if (item == null ? target == null : item.equals(target))
        return i;
    }
    return -1;
  }

  /**
   * Returns the GridIndex where the target is found, null if not found
   * @param target the item to search for
   * @return the GridIndex where the target is located or null
   */
  public static <T> GridIndex indexOf2D(T[][] array, T target) {
    for (int r = 0; r < array.length; r++)
      for (int c = 0; c < array[0].length; c++) {
        T item = array[r][c];
        if (item == null ? target == null : item.equals(target))
          return new GridIndex(r, c);
      }
    return null;
  }

  /**
   * Compares two arrays for equality
   * @param arrayA the array to compare to arrayB
   * @param arrayB the array to compare to arrayA
   * @return whether the two arrays are equal
   */
  public static <T> boolean equals(T[] arrayA, T[] arrayB) {
    int length = arrayA.length;
    if (length != arrayB.length)
      return false;
    for (int i = 0; i < length; i++) {
      T a = arrayA[i], b = arrayB[i];
      if (!(a == null ? b == null : a.equals(b))) {
        System.err.println("Array " + toString(arrayA) + " differs from "
            + toString(arrayB) + ".");
        return false;
      }
    }
    return true;
  }

  /**
   * Compares two 2D arrays for equality
   * @param arrayA the 2D array to compare to arrayB
   * @param arrayB the 2D array to compare to arrayA
   * @return whether the two 2D arrays are equal
   */
  public static <T> boolean equals2D(T[][] arrayA, T[][] arrayB) {
    int rows = arrayA.length, cols = arrayA[0].length;
    if (rows != arrayB.length || cols != arrayB[0].length)
      return false;
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++) {
        T a = arrayA[r][c], b = arrayB[r][c];
        if (!(a == null ? b == null : a.equals(b))) {
          System.err.println("2D Array " + toString2D(arrayA)
              + " differs from " + toString2D(arrayA) + ".");
          return false;
        }
      }
    return true;
  }
}
