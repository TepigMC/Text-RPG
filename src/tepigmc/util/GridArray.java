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
    clear();
  }

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
   * Creates a copy of the given GridStorage
   * @param gridStorage the GridStorage to copy
   */
  public GridArray(GridStorage<E> gridStorage) {
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
  @SuppressWarnings("unchecked")
  public void setAll(E value) {
    int rows = this.rows, cols = this.cols;
    this.data = (E[][]) new Object[rows][cols];
    for (int r = 0; r < rows; r++) {
      this.data[r] = (E[]) new Object[cols];
      for (int c = 0; c < cols; c++)
        this.data[r][c] = value;
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
   * Compares this with another GridStorage
   * @param compare the GridStorage to compare with
   * @return whether the GridStorage objects contain equal data
   */
  public boolean equals(GridStorage<E> compare) {
    E[][] array = this.data, compareArray = compare.toArray();
    if (this.rows != compare.rows() || this.cols != compare.cols())
      return false;
    for (int r = 0; r < this.rows; r++)
      for (int c = 0; c < this.cols; c++)
        if (!array[r][c].equals(compareArray[r][c])) return false;
    return true;
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
