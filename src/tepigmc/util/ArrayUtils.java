package tepigmc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a collection of useful methods relating to arrays
 * @author Andrew Archibald
 */
public class ArrayUtils {
  /**
   * Converts a List to an array
   * @param list the List to convert
   * @return the resulting array
   */
  public static <T> List<T> toList(T[] array) {
    List<T> list = new ArrayList<T>();
    if (array != null)
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
    if (array != null)
      for (T[] row : array)
        list.add(toList(row));
    return list;
  }

  /**
   * Converts a String array into a 2D Character array with even widths
   * @param strings
   * @return the resulting 2D Character array
   */
  public static Character[][] toCharacterArray2D(String[] strings) {
    if (strings == null)
      return new Character[0][0];
    // Calculate the width of the longest string
    int cols = 0;
    for (String row : strings) {
      int length = row.length();
      if (cols < length)
        cols = length;
    }
    // Convert the String array into a 2D char array
    Character[][] characterArray = new Character[strings.length][cols];
    for (int r = 0; r < strings.length; r++) {
      Character[] characters = new Character[cols];
      for (int c = 0; c < strings[r].length(); c++)
        characters[c] = strings[r].charAt(c);
      characterArray[r] = characters;
    }
    return characterArray;
  }
  
  /**
   * Converts a String array into a 2D char array with even widths
   * @param strings
   * @return the resulting 2D char array
   */
  public static char[][] toCharArray2D(String[] strings) {
    if (strings == null)
      return new char[0][0];
    // Calculate the width of the longest string
    int cols = 0;
    for (String row : strings) {
      int length = row.length();
      if (cols < length)
        cols = length;
    }
    // Convert the String array into a 2D char array
    char[][] charArray = new char[strings.length][cols];
    for (int i = 0; i < strings.length; i++) {
      char[] chars = strings[i].toCharArray();
      if (chars.length != cols)
        chars = Arrays.copyOf(chars, cols);
      charArray[i] = chars;
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
      throws IllegalArgumentException {
    if (fromIndex >= toIndex)
      throw new IllegalArgumentException("Invalid range: from " + fromIndex + " to " + toIndex);
    checkRange(array, toIndex);
    checkRange(array, fromIndex);
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[toIndex - fromIndex];
    for (int i = 0; i < result.length; i++)
      result[i] = array[i + fromIndex];
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
   * @param a the array to merge before b
   * @param b the array to merge after a
   * @return the result of the merge
   */
  public static <T> T[] merge(T[] a, T[] b) {
    int lengthA = a.length, lengthB = b.length;
    T[] merged = Arrays.copyOf(a, lengthA + lengthB);
    for (int i = 0; i < lengthB; i++) {
      merged[i + lengthA] = b[i];
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
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    int length = array.length;
    for (int i = 0; i < length; i++) {
      sb.append(array[i]);
      if (i < length - 1)
        sb.append(", ");
    }
    return sb.append(']').toString();
  }

  /**
   * Creates a String representation of the 2D array
   * @param array to create the String from
   * @return the String representation of the 2D array
   */
  public static <T> String toString2D(T[][] array) {
    if (array == null)
      return "null";
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    int rows = array.length;
    for (int r = 0; r < rows; r++) {
      sb.append(toString(array[r]));
      if (r < rows - 1)
        sb.append(", ");
    }
    return sb.append(']').toString();
  }

  /**
   * Returns the index where the target is found, -1 if not found
   * @param target the item to search for
   * @return the index where the target is located or -1
   */
  public static <T> int indexOf(T[] array, T target) {
    if (array != null)
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
    if (array != null)
      for (int r = 0; r < array.length; r++) {
        int c = indexOf(array[r], target);
        if (c != -1)
          return new GridIndex(r, c);
      }
    return null;
  }

  /**
   * Compares two arrays for equality
   * @param a the array to compare to b
   * @param b the array to compare to a
   * @return whether the two arrays are equal
   */
  public static <T> boolean equals(T[] a, T[] b) {
    if (a == b)
      return true;
    if (a == null || b == null || a.length != b.length)
      return false;
    for (int i = 0; i < a.length; i++) {
      T itemA = a[i], itemB = b[i];
      if (!(itemA == null ? itemB == null : itemA.equals(itemB)))
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
    if (a == b)
      return true;
    if (a == null || b == null || a.length != b.length || a[0].length != b[0].length)
      return false;
    for (int r = 0; r < a.length; r++)
      if (!equals(a[r], b[r]))
        return false;
    return true;
  }

  public static <T> void checkRange(T[] array, int index) {
    if (index > array.length)
      throw new IndexOutOfBoundsException("index: " + index + ", length: " + array.length);
  }
}
