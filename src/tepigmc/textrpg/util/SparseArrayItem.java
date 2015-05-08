package tepigmc.textrpg.util;

public class SparseArrayItem<T> {
  private int row;
  private int col;
  private T data;
  
  public SparseArrayItem(int row, int col, T data) {
    this.setRow(row);
    this.setCol(col);
    this.setData(data);
  }

  public int row() { return row; }
  public int col() { return col; }
  public T data() { return data; }
  
  public int setRow(int row) { this.row = row; return this.row; }
  public int setCol(int col) { this.col = col; return this.col; }
  public T setData(T data) { this.data = data; return this.data; }
}
