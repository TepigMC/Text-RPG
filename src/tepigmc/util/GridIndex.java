package tepigmc.util;

/**
 * This is a row, column position in a grid
 * @author Andrew Archibald
 */
public final class GridIndex {
  private int row;
  private int col;

  /**
   * Constructs a GridIndex with the given row and column
   * @param row the row index in the GridStorage
   * @param col the column index in the GridStorage
   */
  public GridIndex(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Gets the row index
   * @return row
   */
  public int row() {
    return this.row;
  }

  /**
   * Gets the column index
   * @return col
   */
  public int col() {
    return this.col;
  }

  /**
   * Compares this with another Object
   * @param compare the Object to compare with
   * @return whether the Object objects are equal
   */
  public boolean equals(Object compare) {
    if (compare == this)
      return true;
    if (compare instanceof GridIndex) {
      GridIndex item = (GridIndex) compare;
      return this.row == item.row() && this.col == item.col();
    }
    return false;
  }
}
