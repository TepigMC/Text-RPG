package tepigmc.util;

import java.util.List;

/**
 * This stores items in a 2D grid using a 2D array
 * @author Andrew Archibald
 * @param <E> the class of the item stored in the grid
 */
public class GridArray<E> implements Grid<E> {
  private int rows;
  private int cols;
  private E[][] data;

  /**
   * Constructs a GridArray with given data as an array
   * @param data as an array
   */
  public GridArray(E[][] data) {
    set(data);
  }

  /**
   * Constructs a GridArray with given data as a List
   * @param data as a List
   */
  public GridArray(List<List<E>> data) {
    set(data);
  }

  /**
   * Constructs an empty GridArray with given size
   * @param rows the amount of rows to create
   * @param cols the amount of columns to create
   */
  public GridArray(int rows, int cols) {
    this(rows, cols, null);
  }

  /**
   * Constructs a GridList filed with the given item with given size
   * @param rows the amount of rows to create
   * @param cols the amount of columns to create
   */
  public GridArray(int rows, int cols, E item) {
    this.rows = rows;
    this.cols = cols;
    setAll(item);
  }

  /**
   * Creates a copy of the given GridStorage
   * @param gridStorage the GridStorage to copy
   */
  public GridArray(Grid<E> gridStorage) {
    set(gridStorage.toArray());
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
   * @param data the array to set to data
   */
  public void set(E[][] data) {
    this.data = data;
    updateDimensions();
  }

  /**
   * Sets the data to the given List
   * @param data the List to set to data
   */
  public void set(List<List<E>> data) {
    set(ListUtils.toArray2D(data));
  }

  /**
   * Set all the items in data to be a given value
   * @param value the value to set to all the items
   */
  public void setAll(E value) {
    this.data = ArrayUtils.fill2D(this.rows, this.cols, value);
  }

  /**
   * Sets all the items in data to null
   */
  public void clear() {
    setAll(null);
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
    return ArrayUtils.toList2D(this.data);
  }

  /**
   * Creates a GridList with the same data
   * @return data converted to a GridList
   */
  public GridList<E> toGridList() {
    return new GridList<E>(ArrayUtils.toList2D(this.data));
  }

  /**
   * Creates a String representation of this GridArray
   */
  public String toString() {
    return ArrayUtils.toString2D(this.data);
  }

  /**
   * Returns the GridIndex where the target is found, null if not found
   * @param target the item to search for
   * @return the GridIndex where the target is located or null
   */
  public GridIndex indexOf(E target) {
    return ArrayUtils.indexOf2D(this.data, target);
  }
  
  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target) {
    return indexOf(target) != null;
  }

  /**
   * Compares this with another Object
   * @param compare the Object to compare with
   * @return whether the Object objects are equal
   */
  public boolean equals(Object compare) {
    if (compare == this)
      return true;
    if (compare instanceof Grid) {
      @SuppressWarnings("unchecked")
      Grid<E> item = (Grid<E>) compare;
      return ArrayUtils.equals2D(this.data, item.toArray());
    }
    return false;
  }

  /**
   * Throws error if position is out of bounds
   * @param row the row position to verify
   * @param col the column position to verify
   * @exception IndexOutOfBoundsException when position is out of bounds
   */
  private void rangeCheck(int row, int col) {
    if (row < 0 || row >= this.rows || col < 0 || col >= this.cols)
      throw new IndexOutOfBoundsException("Row: " + row + ", Col: " + col
          + ", Rows: " + this.rows + ", Cols: " + this.cols);
  }

  /**
   * Updates rows and cols to match the size of data
   */
  private void updateDimensions() {
    this.rows = this.data.length;
    this.cols = this.data[0].length;
  }
}
