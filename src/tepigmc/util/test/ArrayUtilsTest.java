package tepigmc.util.test;

import static org.junit.Assert.*;

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
}
