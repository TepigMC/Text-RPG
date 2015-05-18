package tepigmc.util;

import java.util.List;

public interface GridStorage<E> /* extends Iterable<Iterator<E>> */{
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
  public E set(int row, int col, E item);

  /**
   * Sets the data to the given data as an array
   * @param data the array to set to data
   * @return the previous data
   */
  public E[][] set(E[][] data);

  /**
   * Sets the data to the given List
   * @param data the List to set to data
   * @return the previous data
   */
  public List<List<E>> set(List<List<E>> data);

  /**
   * Returns true if it contains target
   * @param target the item to search for
   * @return if this contains target
   */
  public boolean contains(E target);

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
   * Compares this with another GridStorage
   * @param compare the GridStorage to compare with
   * @return whether the GridStorage objects contain equal data
   */
  public boolean equals(GridStorage<E> compare);

  /**
   * Allows this to be used in a foreach loop
   * @return an Iterator object
   */
  // public Iterator<Iterator<E>> iterator();
}
