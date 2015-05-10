package tepigmc.util;

public class SparseListItem<E> {
  private int index;
  private E value;
  
  public SparseListItem(int index, E value) {
    this.setIndex(index);
    this.setvalue(value);
  }

  public int index() { return index; }
  public E value() { return value; }
  
  public int setIndex(int index) { this.index = index; return this.index; }
  public E setvalue(E value) { this.value = value; return this.value; }
}
