package tepigmc.util;

import java.util.List;

public class RectangleArray<E> {
  private int rows;
  private int cols;
  private E[][] data;

  /**
   * Constructs an empty MatrixArray with given size
   * @param rows
   * @param cols
   */
  public RectangleArray(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Constructs a MatrixArray with given data as an array
   * @param data as an array
   */
  public RectangleArray(E[][] data) {
    this(data.length, data[0].length);
    set(data);
  }

  /**
   * Constructs a MatrixArray with given data as a List
   * @param data as a List
   */
  public RectangleArray(List<List<E>> data) {
    this(data.size(), ListUtils.getWidth(data));
    set(data);
  }

  /**
   * Gets the number of rows
   * @return rows
   */
  public int rows() {
    return this.rows;
  }

  /**
   * Gets the number of columns
   * @return cols
   */
  public int cols() {
    return this.cols;
  }

  /**
   * Gets the data array
   * @return data
   */
  public E[][] get() {
    return this.data;
  }

  /**
   * Gets the item at the given position
   * @param row the row position
   * @param col the column position
   */
  public E get(int row, int col) {
    rangeCheck(row, col);
    return this.data[row][col];
  }

  /**
   * Sets the data to the given data as an array
   * @param data as an array
   */
  public void set(E[][] data) {
    this.data = data;
  }

  /**
   * Sets the data to the given data as a List
   * @param data as a List
   */
  public void set(List<List<E>> data) {
    this.data = ListUtils.to2DArray(data);
  }

  /**
   * Sets the item at the given position to the given item
   * @param row the row position
   * @param col the column position
   * @param item the item to set to the given position
   */
  public void set(int row, int col, E item) {
    rangeCheck(row, col);
    this.data[row][col] = item;
  }

  /**
   * Gets the data array converted to a List
   * @return data converted to a List
   */
  public List<List<E>> toList() {
    return ArrayUtils.toList(this.data);
  }

  /**
   * Creates a RectangleList with the same data
   * @return data converted to a RectangleList
   */
  public RectangleList<E> toRectangleList() {
    return new RectangleList<E>(ArrayUtils.toList(this.data));
  }

  /**
   * Throws error if position is out of bounds
   * @param row the row position to verify
   * @param col the column position to verify
   * @exception IndexOutOfBoundsException when position is out of bounds
   */
  private void rangeCheck(int row, int col) {
    if (row >= this.rows || col >= this.cols) { throw new IndexOutOfBoundsException(
        "Row: " + row + ", Col: " + col + ", Rows: " + this.rows + ", Cols: "
            + this.cols); }
  }
}
