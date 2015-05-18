package tepigmc.textrpg.world.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textrpg.world.RoomGenerator;
import tepigmc.textrpg.world.RoomLayout;

public class RoomGeneratorTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEmpty() {
    RoomLayout roomLayout = new RoomLayout(3, 2);
    RoomGenerator.empty(roomLayout);
    char[][] layout = { {' ', ' ', ' '}, {' ', ' ', ' '}};
    assertArrayEquals(layout, roomLayout.getLayout());
  }

  @Test
  public void testBorder() {
    RoomLayout roomLayout = new RoomLayout(5, 7);
    RoomGenerator.empty(roomLayout);
    RoomGenerator.border(roomLayout);
    char[][] layout = { {'x', 'x', 'x', 'x', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', ' ', ' ', ' ', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', ' ', ' ', ' ', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', 'x', 'x', 'x', 'x'}};
    assertArrayEquals(layout, roomLayout.getLayout());
  }
}
