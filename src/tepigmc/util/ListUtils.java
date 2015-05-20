package tepigmc.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
  /**
   * Converts a List to an array
   * @param list the List to convert
   * @return the resulting array
   */
  public static <T> T[] toArray(List<T> list) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[list.size()];
    for (int i = 0; i < list.size(); i++)
      array[i] = list.get(i);
    return array;
  }

  /**
   * Converts a 2D List to a 2D array
   * @param list the 2D List to convert
   * @return the resulting 2D array
   */
  public static <T> T[][] toArray2D(List<List<T>> list) {
    int rows = list.size();
    @SuppressWarnings("unchecked")
    T[][] array = (T[][]) new Object[rows][getWidth(list)];
    for (int r = 0; r < rows; r++) {
      List<T> row = list.get(r);
      for (int c = 0; c < row.size(); c++)
        array[r][c] = row.get(c);
    }
    return array;
  }

  /**
   * Gets the width of a 2D List
   * @param list the 2D List to check
   * @return the number of columns in largest row of a 2D List
   */
  public static <T> int getWidth(List<List<T>> list) {
    int cols = 0, size;
    for (List<T> row : list) {
      size = row.size();
      if (size > cols)
        cols = size;
    }
    return cols;
  }

  /**
   * Equalizes the widths of the rows in a 2D List
   * @param list the 2D List to change
   * @return the resulting List
   */
  public static <T> List<List<T>> fixWidths(List<List<T>> list) {
    int cols = getWidth(list);
    for (int r = 0; r < list.size(); r++) {
      List<T> row = list.get(r);
      while (row.size() < cols)
        row.add(null);
    }
    return list;
  }

  /**
   * Creates a new List with all the elements set to the given value
   * @param length the amount of items in the new List
   * @param value the value to fill the new List with
   * @return the filled List
   */
  public static <T> List<T> fill(int length, T value) {
    List<T> array = new ArrayList<T>();
    for (int i = 0; i < length; i++)
      array.add(value);
    return array;
  }

  /**
   * Creates a new 2D List with all the elements set to the given value
   * @param rows the amount of rows in the new 2D List
   * @param cols the amount of columns in the new 2D List
   * @param value the value to fill the new 2D List with
   * @return the filled 2D List
   */
  public static <T> List<List<T>> fill2D(int rows, int cols, T value) {
    List<List<T>> list = new ArrayList<List<T>>();
    for (int r = 0; r < rows; r++) {
      List<T> row = new ArrayList<T>();
      for (int c = 0; c < cols; c++)
        row.add(value);
      list.add(row);
    }
    return list;
  }

  /**
   * Returns the GridIndex where the target is found, null if not found
   * @param target the item to search for
   * @return the GridIndex where the target is located or null
   */
  public static <T> GridIndex indexOf(List<List<T>> list, T target) {
    int rows = list.size();
    for (int r = 0; r < rows; r++) {
      List<T> row = list.get(r);
      for (int c = 0; c < row.size(); c++) {
        T item = row.get(c);
        if (item == null ? target == null : item.equals(target))
          return new GridIndex(r, c);
      }
    }
    return null;
  }
}
