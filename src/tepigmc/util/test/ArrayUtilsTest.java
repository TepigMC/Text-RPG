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
    assertEquals(list, ArrayUtils.toList(new Integer[] {1, 2, 3}));
  }

  @Test
  public void testToList2D() {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(4);
    list2.add(5);
    list2.add(6);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(list1);
    list.add(list2);
    assertEquals(list,
        ArrayUtils.toList2D(new Integer[][] { {1, 2, 3}, {4, 5, 6}}));
  }
  
  @Test
  public void testToCharArray() {
    char[][] charArray = { {'a', 'b', 'c'}, {'d', 'e', 'f'}};
    String[] stringArray = {"abc", "def"};
    assertArrayEquals(charArray, ArrayUtils.toCharArray2D(stringArray));
  }

  @Test
  public void testSubArray() {
    Integer[] array = {1, 2, 3, 4, 5};
    Integer[] subArray = {2, 3, 4};
    assertArrayEquals(subArray, ArrayUtils.subArray(array, 1, 4));
  }

  @Test
  public void testSubArray_length() {
    Integer[] array = {1, 2, 3, 4, 5};
    Integer[] subArray = {2, 3, 4, 5};
    assertArrayEquals(subArray, ArrayUtils.subArray(array, 1));
  }

  @Test
  public void testToString() {
    assertEquals("[1, 2, 3]", ArrayUtils.toString(new Integer[] {1, 2, 3}));
  }

  @Test
  public void testToString2D() {
    assertEquals("[[1, 2, 3], [4, 5, 6]]",
        ArrayUtils.toString2D(new Integer[][] { {1, 2, 3}, {4, 5, 6}}));
  }
}
