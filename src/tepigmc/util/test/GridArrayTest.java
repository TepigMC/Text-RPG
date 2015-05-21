package tepigmc.util.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.util.GridArray;

public class GridArrayTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEquals() {
    assertTrue(new GridArray<Integer>(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } })
        .equals(new GridArray<Integer>(new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 } })));
    assertTrue(new GridArray<Character>(new Character[][] { { '1', '2', '3' }, { '4', '5', '6' } })
        .equals(new GridArray<Character>(new Character[][] { { '1', '2', '3' }, { '4', '5', '6' } })));
  }

  @Test
  public void testEquals_Empty() {
    assertTrue(new GridArray<Integer>(1, 2).equals(new GridArray<Integer>(1, 2)));
  }
}
