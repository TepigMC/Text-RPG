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
    assertTrue(new GridArray<String>(1, 2).equals(new GridArray<String>(1, 2)));
  }
}
