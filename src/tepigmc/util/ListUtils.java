package tepigmc.util;

import java.util.List;

public class ListUtils {
  /**
   * Converts a 2D List to a 2D array
   * @param list the 2D List to convert
   * @return the resulting 2D array
   */
  public static <T> T[][] to2DArray(List<List<T>> list) {
    int rows = list.size();
    int cols = list.get(0).size();
    @SuppressWarnings("unchecked")
    T[][] array = (T[][]) new Object[rows][cols];
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        array[r][c] = list.get(r).get(c);
    return array;
  }

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
   * Gets the width of a 2D List
   * @param list the 2D List to check
   * @return the number of columns in largest row of a 2D List
   */
  public static <T> int getWidth(List<List<T>> list) {
    int cols = 0, size;
    for (List<T> row : list) {
      size = row.size();
      if (size > cols) cols = size;
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
}
