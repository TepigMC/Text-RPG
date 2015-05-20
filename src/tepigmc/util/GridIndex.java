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
}
