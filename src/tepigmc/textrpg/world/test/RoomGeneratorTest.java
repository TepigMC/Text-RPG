package tepigmc.textrpg.world.test;

import static org.junit.Assert.*;

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
    GridStorage<Character> layout = new GridArray<Character>(new Character[][] { { ' ', ' ', ' ' },
        { ' ', ' ', ' ' } });
    assertEquals(layout, roomTemplate.getTemplate());
    assertArrayEquals(layout.toArray(), roomTemplate.getTemplate().toArray());
  }

  @Test
  public void testBorder() {
    RoomTemplate roomTemplate = new RoomTemplate(7, 5);
    RoomGenerator.empty(roomTemplate);
    RoomGenerator.border(roomTemplate);
    GridStorage<Character> layout = new GridArray<Character>(new Character[][] {
        { 'x', 'x', 'x', 'x', 'x' }, { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', 'x', 'x', 'x', 'x' } });
    assertEquals(layout, roomTemplate.getTemplate());
  }
}
