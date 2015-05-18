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
  public static <T> List<List<T>> toList(T[][] array) {
    List<List<T>> list = new ArrayList<List<T>>();
    for (T[] row : array) {
      list.add(toList(row));
    }
    return list;
  }

  /**
   * Converts a String array into a 2D char array with even widths
   * @param stringArray
   * @return
   */
  public static char[][] toCharArray(String[] stringArray) {
    // Calculate the width of the longest string
    int width = 0;
    int height = stringArray.length;
    for (String row : stringArray) {
      int length = row.length();
      if (width < length) width = length;
    }
    // Convert the String array into a 2D char array
    char[][] charArray = new char[height][width];
    for (int i = 0; i < height; i++) {
      char[] row = stringArray[i].toCharArray();
      if (row.length != width) row = Arrays.copyOf(row, width);
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
  public static <T> T[] subArray(T[] array, int startIndex)
      throws IndexOutOfBoundsException, IllegalArgumentException {
    return subArray(array, startIndex, array.length);
  }

  /**
   * Merges two arrays
   * @param a the array to merge before b
   * @param b the array to merge after a
   * @return the result of the merge
   */
  public static <T> T[] merge(T[] a, T[] b) {
    int lengthA = a.length, lengthB = b.length;
    T[] result = Arrays.copyOf(a, lengthA + lengthB);
    for (int i = 0; i < lengthB; i++) {
      result[i + lengthA] = b[i];
    }
    return result;
  }
  
  /**
   * Creates a String representation of the array
   * @param array to create the String from
   * @return the String representation of the array
   */
  public static <T> String toString(T[] array) {
    if (array == null) return "null";
    String arrayString = "[";
    for (int i = 0; i < array.length; i++)
      arrayString += array[i] + (i < array.length - 1 ? "," : "");
    return arrayString + "]";
  }

  /**
   * Creates a String representation of the array
   * @param array to create the String from
   * @return the String representation of the array
   */
  public static <T> String toString(T[][] array) {
    String arrayString = "[";
    for (int i = 0; i < array.length; i++) {
      arrayString += "[";
      for (int j = 0; j < array[0].length; j++)
        arrayString += array[i][j] + (j < array[0].length - 1 ? "," : "");
      arrayString += "]" + (i < array.length - 1 ? "," : "]");
    }
    return arrayString;
  }

  /**
   * Compares two arrays for equality
   * @param a the array to compare to b
   * @param b the array to compare to a
   * @return whether the two arrays are equal
   */
  public static <T> boolean equals(T[] a, T[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i < a.length; i++)
      if (!a[i].equals(b[i])) {
        System.err.println("Array " + toString(a) + " differs from "
            + toString(b) + ".");
        return false;
      }
    return true;
  }

  /**
   * Compares two 2D arrays for equality
   * @param a the 2D array to compare to b
   * @param b the 2D array to compare to a
   * @return whether the two 2D arrays are equal
   */
  public static <T> boolean equals2D(T[][] a, T[][] b) {
    if (a.length != b.length || a[0].length != b[0].length) return false;
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[0].length; j++)
        if (!a[i][j].equals(b[i][j])) {
          System.err.println("Array " + toString(a) + " differs from "
              + toString(b) + ".");
          return false;
        }
    return true;
  }
}
