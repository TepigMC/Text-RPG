package tepigmc.util;

import java.util.List;

public class RectangleArray<E> {
  private int rows;
  private int cols;
  private E[][] data;
  
  /**
   * Constructs an empty MatrixArray with given size
   * @param rows
   * @param cols
   */
  public RectangleArray(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }
  
  /**
   * Constructs a MatrixArray with given data as an array
   * @param data as an array
   */
  public RectangleArray(E[][] data) {
    this(data.length, data[0].length);
    setData(data);
  }
  
  /**
   * Constructs a MatrixArray with given data as a List
   * @param data as a List
   */
  public RectangleArray(List<List<E>> data) {
    this(data.size(), ListUtils.getListWidth(data));
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
   * Gets the data array
   * @return data
   */
  public E[][] getData() {
    return this.data;
  }
  
  /**
   * Gets the data array converted to a List
   * @return data converted to a List
   */
  public List<List<E>> toList() {
    return ListUtils.toList(this.data);
  }
  
  /**
   * Sets the data to the given data as an array
   * @param data as an array
   */
  public void setData(E[][] data) {
    this.data = data;
  }
  
  /**
   * Sets the data to the given data as a List
   * @param data as a List
   */
  public void setData(List<List<E>> data) {
    this.data = ListUtils.toArray(data);
  }
}
