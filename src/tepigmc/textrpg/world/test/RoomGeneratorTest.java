package tepigmc.textrpg.world.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textrpg.world.RoomGenerator;
import tepigmc.textrpg.world.RoomTemplate;
import tepigmc.util.GridArray;
import tepigmc.util.GridStorage;

public class RoomGeneratorTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEmpty() {
    RoomTemplate roomTemplate = new RoomTemplate(2, 3);
    RoomGenerator.empty(roomTemplate);
    GridStorage<Character> layout = new GridArray<Character>(new Character[][] {
        {' ', ' ', ' '}, {' ', ' ', ' '}});
    assertEquals(layout, roomTemplate.getTemplate());
  }

  @Test
  public void testBorder() {
    RoomTemplate roomTemplate = new RoomTemplate(5, 7);
    RoomGenerator.empty(roomTemplate);
    RoomGenerator.border(roomTemplate);
    GridStorage<Character> layout = new GridArray<Character>(new Character[][] {
        {'x', 'x', 'x', 'x', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', ' ', ' ', ' ', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', ' ', ' ', ' ', 'x'}, {'x', ' ', ' ', ' ', 'x'},
        {'x', 'x', 'x', 'x', 'x'}});
    assertEquals(layout, roomTemplate.getTemplate());
  }
}
