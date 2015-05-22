package tepigmc.textrpg.world.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textrpg.world.RoomGeneration;
import tepigmc.textrpg.world.RoomTemplate;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;

public class RoomGenerationTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEmpty() {
    RoomTemplate roomTemplate = new RoomTemplate(2, 3);
    RoomGeneration.empty(roomTemplate);
    Grid<Character> layout = new GridArray<Character>(new Character[][] {
        { ' ', ' ', ' ' }, { ' ', ' ', ' ' } });
    assertEquals(layout, roomTemplate.getGrid());
    assertArrayEquals(layout.toArray(), roomTemplate.getGrid().toArray());
  }

  @Test
  public void testBorder() {
    RoomTemplate roomTemplate = new RoomTemplate(7, 5);
    RoomGeneration.border(roomTemplate);
    Grid<Character> layout = new GridArray<Character>(new Character[][] {
        { 'x', 'x', 'x', 'x', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', 'x', 'x', 'x', 'x' } });
    assertEquals(layout, roomTemplate.getGrid());
  }
}
