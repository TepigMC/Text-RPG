package tepigmc.textrpg.world.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tepigmc.textrpg.entity.Entity;
import tepigmc.textrpg.entity.NonPlayerCharacter;
import tepigmc.textrpg.entity.Player;
import tepigmc.textrpg.world.Coordinates;
import tepigmc.textrpg.world.Exit;
import tepigmc.textrpg.world.Room;
import tepigmc.textrpg.world.RoomRenderer;
import tepigmc.textrpg.world.Tile;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;

public class RoomRendererTest {
  final Tile x = new Tile("test_a", 'x', true);
  final Tile o = new Tile("test_b", ' ', false);
  final Player player = new Player(new Coordinates(1, 2), 'P');
  final Entity e1 = new NonPlayerCharacter(new Coordinates(2, 1), 'A');
  final Entity e2 = new NonPlayerCharacter(new Coordinates(2, 2), 'B');
  Grid<Tile> tiles;
  List<Entity> entities;
  List<Exit> exits;
  Room room;
  Room roomExtended;

  @Before
  public void setUp() throws Exception {
    tiles = new GridArray<Tile>(new Tile[][] { { x, x, x, x }, { x, o, o, x },
        { x, o, o, x }, { x, x, x, x } });
    entities = new ArrayList<Entity>();
    entities.add(e1);
    entities.add(e2);
    room = new Room(tiles);
    roomExtended = new Room(tiles, entities, exits);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testRender() {
    assertEquals("xxxx\nx  x\nx  x\nxxxx", new RoomRenderer(room).render());
  }

  @Test
  public void testRender_player() {
    assertEquals("xxxx\nx  x\nxP x\nxxxx", new RoomRenderer(room, player).render());
  }

  @Test
  public void testRender_entities() {
    assertEquals("xxxx\nx Ax\nx Bx\nxxxx", new RoomRenderer(roomExtended).render());
  }

  @Test
  public void testRender_entitiesAndPlayer() {
    assertEquals("xxxx\nx Ax\nxPBx\nxxxx",
        new RoomRenderer(roomExtended, player).render());
  }
}
