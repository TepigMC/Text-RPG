package tepigmc.util.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.util.ArrayUtils;

public class ArrayUtilsTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testToList() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(list, ArrayUtils.toList(new Integer[] { 1, 2, 3 }));
  }

  @Test
  public void testToList_empty() {
    List<Integer> list = new ArrayList<Integer>();
    assertEquals(list, ArrayUtils.toList(new Integer[0]));
  }

  @Test
  public void testToList_null() {
    List<Integer> list = new ArrayList<Integer>();
    assertEquals(list, ArrayUtils.toList(null));
  }

  @Test
  public void testToList2D() {
    List<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(2);
    a.add(3);
    List<Integer> b = new ArrayList<Integer>();
    b.add(4);
    b.add(5);
    b.add(6);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(a);
    list.add(b);
    assertEquals(list, ArrayUtils.toList2D(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
  }

  @Test
  public void testToList2D_empty() {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    assertEquals(list, ArrayUtils.toList2D(new Integer[0][0]));
  }

  @Test
  public void testToCharArray2D() {
    char[][] charArray = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
    String[] stringArray = { "abc", "def" };
    assertArrayEquals(charArray, ArrayUtils.toCharArray2D(stringArray));
  }

  @Test
  public void testSubArray() {
    Integer[] array = { 1, 2, 3, 4, 5 };
    Integer[] subArray = { 2, 3, 4 };
    assertArrayEquals(subArray, ArrayUtils.subArray(array, 1, 4));
  }

  @Test
  public void testSubArray_length() {
    Integer[] array = { 1, 2, 3, 4, 5 };
    Integer[] subArray = { 2, 3, 4, 5 };
    assertArrayEquals(subArray, ArrayUtils.subArray(array, 1));
  }

  @Test
  public void testToString() {
    assertEquals("[1, 2, 3]", ArrayUtils.toString(new Integer[] { 1, 2, 3 }));
  }

  @Test
  public void testToString2D() {
    assertEquals("[[1, 2, 3], [4, 5, 6]]",
        ArrayUtils.toString2D(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
  }

  @Test
  public void testEquals_integer() {
    Integer[] a = new Integer[] { 1, 2, 3 };
    Integer[] b = new Integer[] { 1, 2, 3 };
    assertTrue(ArrayUtils.equals(a, b));
    assertArrayEquals(a, b);
  }

  @Test
  public void testEquals_character() {
    Character[] a = new Character[] { '1', '2', '3' };
    Character[] b = new Character[] { '1', '2', '3' };
    assertTrue(ArrayUtils.equals(a, b));
    assertArrayEquals(a, b);
  }

  @Test
  public void testEquals2D_integer() {
    Integer[][] a = new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } };
    Integer[][] b = new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } };
    assertTrue(ArrayUtils.equals2D(a, b));
    assertArrayEquals(a, b);
  }

  @Test
  public void testEquals2D_character() {
    Character[][] a = new Character[][] { { '1', '2', '3' }, { '4', '5', '6' } };
    Character[][] b = new Character[][] { { '1', '2', '3' }, { '4', '5', '6' } };
    assertTrue(ArrayUtils.equals2D(a, b));
    assertArrayEquals(a, b);
  }
}
