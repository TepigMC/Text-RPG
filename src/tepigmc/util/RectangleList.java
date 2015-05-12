package tepigmc.util;

import java.util.List;

public class RectangleList<E> {
  private int rows;
  private int cols;
  private List<List<E>> data;
  
  public RectangleList(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
  }
  
  public RectangleList(E[][] data) {
    this(data.length, data[0].length);
    setData(data);
  }
  
  public RectangleList(List<List<E>> data) {
    this(data.size(), ListUtils.getListWidth(data));
    setData(data);
  }
  
  public int rows() { return this.rows; }
  public int cols() { return this.cols; }
  
  public List<List<E>> getData() { return this.data; }
  
  public void setData(List<List<E>> data) {
    this.data = ListUtils.fixWidths(data);
  }
  
  public void setData(E[][] data) {
    this.data = ListUtils.toList(data);
  }
  
  /**
   * Converts data to an array
   * @return data converted to an array
   */
  public E[][] toArray() {
    return ListUtils.toArray(this.data);
  }
}
