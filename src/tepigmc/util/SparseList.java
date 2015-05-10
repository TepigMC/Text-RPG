package tepigmc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SparseList<E> implements List<E> {
  private int size;
  private List<SparseListItem<E>> items;
  private E emptyItem;

  public SparseList(int size, E emptyItem) {
    this.size = size;
    this.items = new ArrayList<SparseListItem<E>>();
    this.emptyItem = null;
  }

  public SparseList(E[] array, E emptyItem) {
    this(array.length, emptyItem);
    for (E item : array) {
      add(item);
    }
  }

  public SparseList(Collection<E> collection, E emptyItem) {
    this(collection.size(), emptyItem);
    for (E item : collection) {
      add(item);
    }
  }

  private void addItem(SparseListItem<E> item) {
    addItem(item, false);
  }
  
  private void addItem(SparseListItem<E> item, boolean shift) {
    int index = item.index();
    if (shift) {
      this.size++;
    }
    if (index > this.size) {
      this.size = index + 1;
    }
    if (!item.equals(this.emptyItem)) {
      for (int i = 0; i < this.items.size(); i++) {
        if (this.items.get(i).index() > index) {
          this.items.add(i, item);
          return;
        }
      }
      this.items.add(item);
    }
  }
  
  /** Shifts all items by amount; Removes all overflowing items */
  public void shiftItems(int amount) { shiftItems(0, amount); }
  
  /** Shifts items starting at index by amount; Removes all overflowing items */
  public void shiftItems(int index, int amount) {
    int i = 0;
    while (i < this.items.size()) {
      SparseListItem<E> item = this.items.get(i);
      int itemIndex = item.index(), newIndex = itemIndex + amount;
      if (newIndex >= this.size || newIndex < 0) {
        items.remove(i);
      }
      else {
        if (itemIndex >= index) {
          item.setIndex(newIndex);
        }
        i++;
      }
    }
  }

  /** Appends the specified element to the end of this list */
  public boolean add(E item) {
    addItem(new SparseListItem<E>(this.size - 1, item));
    return false;
  }

  /** Inserts the specified element at the specified position in this list */
  public void add(int index, E item) {
    addItem(new SparseListItem<E>(index, item));
    shiftItems(index + 1, 1);
  }

  /** Appends all of the elements in the specified collection to the end of this list */
  public boolean addAll(Collection<? extends E> collection) {
    for (E item : collection) {
      add(item);
    }
    return true;
  }
  
  /** Inserts all of the elements in the specified collection into this list at the specified position */
  public boolean addAll(int index, Collection<? extends E> collection) {
    for (E item : collection) {
      add(index, item);
      index++;
    }
    return true;
  }

  /** Removes all of the elements from this list, but maintains list size */
  public void clear() {
    this.items.clear();
  }

  /** Returns true if this list contains the specified element */
  public boolean contains(Object target) {
    return indexOf(target) >= 0;
  }

  /** Returns true if this list contains all of the elements of the specified collection */
  public boolean containsAll(Collection<?> collection) {
    for (Object item : collection) {
      if (!contains(item)) {
        return false;
      }
    }
    return false;
  }

  public E get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  public int indexOf(Object target) {
    // TODO!!!
    if (target.equals(emptyItem) && this.items.size() < this.size) {
      for (int i = 0; i < this.size; i++) {
        
      }
    }
    for (int i = 0; i < this.items.size(); i++) {
      if (this.items.get(i).value().equals(target)) {
        return i;
      }
    }
    return -1;
  }

  /** Returns true if this list contains only empty elements */
  public boolean isEmpty() {
    return this.items.size() == 0;
  }

  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  public int lastIndexOf(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  public ListIterator<E> listIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  public ListIterator<E> listIterator(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  public E remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  public E set(int index, E element) {
    // TODO Auto-generated method stub
    return null;
  }

  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  public List<E> subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    return null;
  }
  
  /** @return array with all items and empty items */
  public Object[] toArray() {
    Object[] array = new Object[this.size];
    for (int i = 0; i < array.length; i++) {
      array[i] = this.emptyItem;
    }
    for (SparseListItem<E> item : this.items) {
      array[item.index()] = item.value();
    }
    return array;
  }

  /** @return array of type T[] with all items and empty items */
  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] a) {
    return (T[]) toArray();
  }
}
