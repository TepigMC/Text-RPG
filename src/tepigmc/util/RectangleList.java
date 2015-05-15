package tepigmc.util;

import java.util.List;

public class RectangleList<E> {
  private int rows;
  private int cols;
  private List<List<E>> data;
  
  /**
   * Constructs an empty RectangleList with given size
   * @param rows
   * @param cols
   */
  public RectangleList(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }
  
  /**
   * Constructs a RectangeList with given data as an array
   * @param data as an array
   */
  public RectangleList(E[][] data) {
    this(data.length, data[0].length);
    setData(data);
  }
  
  /**
   * Constructs a RectangleList with given data as a List
   * @param data as a List
   */
  public RectangleList(List<List<E>> data) {
    this(data.size(), ListUtils.getWidth(data));
    setData(data);
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
   * Gets the data List
   * @return data
   */
  public List<List<E>> getData() {
    return this.data;
  }
  
  /**
   * Gets the data List converted to an array
   * @return data converted to an array
   */
  public E[][] toArray() {
    return ListUtils.to2DArray(this.data);
  }
  
  /**
   * Sets the data to the given List
   * @param data the List to set data to
   */
  public void setData(List<List<E>> data) {
    this.data = ListUtils.fixWidths(data);
  }
  
  /**
   * Sets the data to the given array
   * @param data the array to set data to
   */
  public void setData(E[][] data) {
    this.data = ArrayUtils.toList(data);
  }
}
