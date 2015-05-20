package tepigmc.util;

import java.util.List;

/**
 * This stores items in a 2D grid similar to a 2D array
 * @author Andrew Archibald
 * @param <E> the class of the item stored in the grid
 */
public interface GridStorage<E> {
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
   * @return the item that was previously at that position
   */
  public void set(int row, int col, E item);

  /**
   * Sets the data to the given data as an array
   * @param data the array to set to data
   * @return the previous data
   */
  public void set(E[][] data);

  /**
   * Sets the data to the given List
   * @param data the List to set to data
   * @return the previous data
   */
  public void set(List<List<E>> data);

  /**
   * Set all the items in data to be a given value
   * @param value the value to set to all the items
   */
  public void setAll(E value);

  /**
   * Sets all the items in data to null
   */
  public void clear();

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

  /**
   * Creates a String representation of this GridStorage
   */
  public String toString();

  /**
   * Returns the GridIndex where the target is found, null if not found
   * @param target the item to search for
   * @return the GridIndex where the target is located or null
   */
  public GridIndex indexOf(E target);

  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target);

  /**
   * Compares this with another GridStorage
   * @param compare the GridStorage to compare with
   * @return whether the GridStorage objects contain equal data
   */
  public boolean equals(GridStorage<E> compare);
}
