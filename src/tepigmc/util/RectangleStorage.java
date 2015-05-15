package tepigmc.util;

import java.util.List;

public interface RectangleStorage<E> {
  /**
   * Gets the number of rows
   * @return rows
   */
  public int rows();

  /**
   * Gets the number of columns
   * @return cols
   */
  public int cols();

  /**
   * Gets the item at the given position
   * @param row the row position
   * @param col the column position
   */
  public E get(int row, int col);
  
  /**
   * Sets the item at the given position to the given item
   * @param row the row position
   * @param col the column position
   * @param item the item to set to the given position
   */
  public void set(int row, int col, E item);

  /**
   * Sets the data to the given data as an array
   * @param data as an array
   */
  public void set(E[][] data);

  /**
   * Sets the data to the given data as a List
   * @param data as a List
   */
  public void set(List<List<E>> data);

  /**
   * Gets the data List converted to an array
   * @return data converted to an array
   */
  public E[][] toArray();

  /**
   * Gets the data array converted to a List
   * @return data converted to a List
   */
  public List<List<E>> toList();
}
