package tepigmc.util;

import java.util.List;

public class RectangleList<E> {
  private int rows;
  private int cols;
  private List<List<E>> data;

  /**
   * Constructs an empty RectangleList with given size
   * @param rows
   * @param cols
   */
  public RectangleList(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Constructs a RectangeList with given data as an array
   * @param data as an array
   */
  public RectangleList(E[][] data) {
    this(data.length, data[0].length);
    set(data);
  }

  /**
   * Constructs a RectangleList with given data as a List
   * @param data as a List
   */
  public RectangleList(List<List<E>> data) {
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
   * Gets the data List
   * @return data
   */
  public List<List<E>> get() {
    return this.data;
  }

  /**
   * Gets the item at the given position
   * @param row the row position
   * @param col the column position
   */
  public void get(int row, int col) {
    rangeCheck(row, col);
    this.data.get(row).get(col);
  }

  /**
   * Sets the data to the given List
   * @param data the List to set data to
   */
  public void set(List<List<E>> data) {
    this.data = ListUtils.fixWidths(data);
  }

  /**
   * Sets the data to the given array
   * @param data the array to set data to
   */
  public void set(E[][] data) {
    this.data = ArrayUtils.toList(data);
  }

  /**
   * Sets the item at the given position to the given item
   * @param row the row position
   * @param col the column position
   * @param item the item to set to the given position
   */
  public void set(int row, int col, E item) {
    rangeCheck(row, col);
    this.data.get(row).set(col, item);
  }

  /**
   * Gets the data List converted to an array
   * @return data converted to an array
   */
  public E[][] toArray() {
    return ListUtils.to2DArray(this.data);
  }

  /**
   * Creates a RectangleArray with the same data
   * @return data converted to an RectangleArray
   */
  public RectangleArray<E> toRectangleArray() {
    return new RectangleArray<E>(ListUtils.to2DArray(this.data));
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
