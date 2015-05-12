package tepigmc.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
  /**
   * Gets the width of a List
   * @param list the list to check
   * @return the number of columns in largest row of a 2D List
   */
  public static <T> int getListWidth(List<List<T>> list) {
    int cols = 0, size;
    for (List<T> row : list) {
      size = row.size();
      if (size > cols) {
        cols = size;
      }
    }
    return cols;
  }

  /**
   * Converts a 2D List to a 2D array
   * @param list the List to convert
   * @return the resulting array
   */
  public static <T> T[][] toArray(List<List<T>> list) {
    int rows = list.size();
    int cols = list.get(0).size();
    @SuppressWarnings("unchecked")
    T[][] array = (T[][]) new Object[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        array[r][c] = list.get(r).get(c);
      }
    }
    return array;
  }
  
  
  /**
   * Converts a 2D array to a 2D List
   * @param array the array to convert
   * @return the resulting 2D List
   */
  public static <T> List<List<T>> toList(T[][] array) {
    List<List<T>> list = new ArrayList<List<T>>();
    for (T[] row : array) {
      List<T> rowList = new ArrayList<T>();
      for (T item : row) {
        rowList.add(item);
      }
      list.add(rowList);
    }
    return list;
  }

  /**
   * Converts an irregularly sized List into a rectangular List
   * @param list the List to convert
   * @return the resulting List
   */
  public static <T> List<List<T>> fixWidths(List<List<T>> list) {
    int cols = getListWidth(list);
    for (int r = 0; r < list.size(); r++) {
      List<T> row = list.get(r);
      while (row.size() < cols) {
        row.add(null);
      }
    }
    return list;
  }
}
