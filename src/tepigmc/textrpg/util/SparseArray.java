package tepigmc.textrpg.util;

import java.util.ArrayList;
import java.util.List;

public class SparseArray<T> {
  private int rows;
  private int cols;
  private List<SparseArrayItem<T>> items;
  
  public SparseArray(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.items = new ArrayList<SparseArrayItem<T>>();
  }
  
  public SparseArray(T[][] array) {
    this(array.length, array[0].length);
  }
  
  public SparseArray(List<List<T>> list) {
    this(list.size(), getListCols(list));
  }
  
  private static <T> int getListCols(List<List<T>> list) {
    int cols = 0, size;
    for (List<T> row : list) {
      size = row.size();
      if (size > cols) { cols = size; }
    }
    return cols;
  }
}
