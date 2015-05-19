package tepigmc.util;

import java.util.ArrayList;
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
    setAll(null);
  }

  /**
   * Constructs a GridList with given data as an array
   * @param data as an array
   */
  public GridList(E[][] data) {
    set(data);
  }

  /**
   * Constructs a GridList with given data as a List
   * @param data as a List
   */
  public GridList(List<List<E>> data) {
    set(data);
  }

  /**
   * Creates a copy of the given GridStorage
   * @param gridStorage the GridStorage to copy
   */
  public GridList(GridStorage<E> gridStorage) {
    set(gridStorage.toList());
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
   */
  public void set(int row, int col, E item) {
    rangeCheck(row, col);
    this.data.get(row).set(col, item);
  }

  /**
   * Sets the data to the given data as an array
   * @param data the array to set to data
   */
  public void set(E[][] data) {
    set(ArrayUtils.toList2D(data));
  }

  /**
   * Sets the data to the given List; Makes the widths of the List even
   * @param data the List to set to data
   */
  public void set(List<List<E>> data) {
    this.data = ListUtils.fixWidths(data);
    updateDimensions();
  }

  /**
   * Set all the items in data to be a given value
   * @param value the value to set to all the items
   */
  public void setAll(E value) {
    this.data = new ArrayList<List<E>>();
    for (int r = 0; r < this.rows; r++) {
      List<E> row = new ArrayList<E>();
      for (int c = 0; c < this.cols; c++)
        row.add(value);
      this.data.add(row);
    }
  }

  /**
   * Sets all the items in data to null
   */
  public void clear() {
    setAll(null);
  }

  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target) {
    for (List<E> row : this.data)
      for (E item : row)
        if (item.equals(target)) return true;
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
   * Compares this with another GridStorage
   * @param compare the GridStorage to compare with
   * @return whether the GridStorage objects contain equal data
   */
  public boolean equals(GridStorage<E> compare) {
    return this.data.equals(compare.toList());
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
    this.rows = this.data.size();
    this.cols = this.data.get(0).size();
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
