package tepigmc.util;

import java.util.List;

public class GridList<E> implements GridStorage<E> {
  private int rows;
  private int cols;
  private List<List<E>> data;

  /**
   * Constructs an empty GridList with given size
   * @param rows
   * @param cols
   */
  public GridList(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Constructs a RectangeList with given data as an array
   * @param data as an array
   */
  public GridList(E[][] data) {
    this(data.length, data[0].length);
    set(data);
  }

  /**
   * Constructs a GridList with given data as a List
   * @param data as a List
   */
  public GridList(List<List<E>> data) {
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
    return this.data.get(row).get(col);
  }

  /**
   * Sets the item at the given position to the given item
   * @param row the row position
   * @param col the column position
   * @param item the item to set to the given position
   * @return the item that was previously at that position
   */
  public E set(int row, int col, E item) {
    rangeCheck(row, col);
    E previous = this.data.get(row).get(col);
    this.data.get(row).set(col, item);
    return previous;
  }

  /**
   * Sets the data to the given data as an array
   * @param data the array to set to data
   * @return the previous data
   */
  public E[][] set(E[][] data) {
    E[][] previous = ListUtils.toArray2D(this.data);
    this.data = ArrayUtils.toList2D(data);
    return previous;
  }

  /**
   * Sets the data to the given List; Makes the widths of the List even
   * @param data the List to set to data
   * @return the previous data
   */
  public List<List<E>> set(List<List<E>> data) {
    List<List<E>> previous = this.data;
    this.data = ListUtils.fixWidths(data);
    return previous;
  }

  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target) {
    for (List<E> row : this.data)
      for (E item : row)
        if (item.equals(target))
          return true;
    return false;
  }

  /**
   * Gets the data List converted to an array
   * @return data converted to an array
   */
  public E[][] toArray() {
    return ListUtils.toArray2D(this.data);
  }

  /**
   * Gets the data List
   * @return data
   */
  public List<List<E>> toList() {
    return this.data;
  }

  /**
   * Creates a GridArray with the same data
   * @return data converted to an GridArray
   */
  public GridArray<E> toGridArray() {
    return new GridArray<E>(ListUtils.toArray2D(this.data));
  }

  /**
   * Creates a String representation of this GridList
   */
  public String toString() {
    return this.data.toString();
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
   * ArrayList<Iterator<E>>(); for (List<E> row : this.data)
   * iterators.add(row.iterator()); return iterators.iterator(); }
   */
}
