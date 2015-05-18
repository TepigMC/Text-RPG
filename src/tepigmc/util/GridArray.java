package tepigmc.util;

import java.util.List;

public class GridArray<E> implements GridStorage<E> {
  private int rows;
  private int cols;
  private E[][] data;

  /**
   * Constructs an empty GridArray with given size
   * @param rows
   * @param cols
   */
  public GridArray(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Constructs a GridArray with given data as an array
   * @param data as an array
   */
  public GridArray(E[][] data) {
    this(data.length, data[0].length);
    set(data);
  }

  /**
   * Constructs a GridArray with given data as a List
   * @param data as a List
   */
  public GridArray(List<List<E>> data) {
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
   * Gets the item at the given position
   * @param row the row position
   * @param col the column position
   */
  public E get(int row, int col) {
    rangeCheck(row, col);
    return this.data[row][col];
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
    this.data = ListUtils.toArray2D(data);
  }

  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target) {
    for (E[] row : this.data)
      for (E item : row)
        if (item.equals(target)) return true;
    return false;
  }

  /**
   * Gets the data array
   * @return data
   */
  public E[][] toArray() {
    return this.data;
  }

  /**
   * Gets the data array converted to a List
   * @return data converted to a List
   */
  public List<List<E>> toList() {
    return ArrayUtils.toList(this.data);
  }

  /**
   * Creates a GridList with the same data
   * @return data converted to a GridList
   */
  public GridList<E> toGridList() {
    return new GridList<E>(ArrayUtils.toList(this.data));
  }

  /**
   * Throws error if position is out of bounds
   * @param row the row position to verify
   * @param col the column position to verify
   * @exception IndexOutOfBoundsException when position is out of bounds
   */
  private void rangeCheck(int row, int col) {
    if (row >= this.rows || col >= this.cols)
      throw new IndexOutOfBoundsException("Row: " + row + ", Col: " + col
          + ", Rows: " + this.rows + ", Cols: " + this.cols);
  }

  /**
   * Allows this to be used in a foreach loop
   * @return an Iterator object
   */
  /*
   * public Iterator<Iterator<E>> iterator() { List<Iterator<E>> iterators = new
   * ArrayList<Iterator<E>>(); for (E[] row : this.data) { List<E> rowList =
   * ArrayUtils.toList(row); iterators.add(rowList.iterator()); } return
   * iterators.iterator(); }
   */
}
