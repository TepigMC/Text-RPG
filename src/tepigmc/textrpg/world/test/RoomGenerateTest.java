package tepigmc.textrpg.world.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textrpg.world.RoomGenerate;
import tepigmc.textrpg.world.RoomTemplate;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;

public class RoomGenerateTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEmpty() {
    RoomTemplate roomTemplate = new RoomTemplate(2, 3);
    RoomGenerate.empty(roomTemplate);
    Grid<Character> layout = new GridArray<Character>(new Character[][] {
        { ' ', ' ', ' ' }, { ' ', ' ', ' ' } });
    assertEquals(layout, roomTemplate.getGrid());
    assertArrayEquals(layout.toArray(), roomTemplate.getGrid().toArray());
  }

  @Test
  public void testBorder() {
    RoomTemplate roomTemplate = new RoomTemplate(7, 5);
    RoomGenerate.border(roomTemplate);
    Grid<Character> layout = new GridArray<Character>(new Character[][] {
        { 'x', 'x', 'x', 'x', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', ' ', ' ', ' ', 'x' }, { 'x', ' ', ' ', ' ', 'x' },
        { 'x', 'x', 'x', 'x', 'x' } });
    assertEquals(layout, roomTemplate.getGrid());
  }
}
