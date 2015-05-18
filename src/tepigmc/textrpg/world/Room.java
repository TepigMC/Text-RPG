package tepigmc.textrpg.world;

import java.util.ArrayList;
import java.util.List;

import tepigmc.textrpg.entity.Entity;
import tepigmc.util.GridStorage;

public class Room {
  private static int nextId = 0;

  private GridStorage<Tile> tiles;
  private List<Entity> entities;
  private int id;

  /**
   * Constructs a Room with a Tile GridStorage and a List of Entity objects
   * @param tiles a GridStorage of Tiles
   * @param entities a List of Entities
   */
  public Room(GridStorage<Tile> tiles, List<Entity> entities) {
    this.tiles = tiles;
    this.entities = entities;
    this.id = nextId;
    nextId++;
  }

  /**
   * Constructs a Room with a Tile GridStorage and no Entity objects
   * @param tiles a GridStorage of Tiles
   */
  public Room(GridStorage<Tile> tiles) {
    this(tiles, new ArrayList<Entity>());
  }
  
  /**
   * Constructs a Room from a RoomTemplate
   * @param roomTemplate the RoomTemplate to create the World from
   */
  public Room(RoomTemplate roomTemplate) {
    this(roomTemplate.createTiles());
  }

  /**
   * Gets the tiles GridStorage
   * @return tiles
   */
  public GridStorage<Tile> getTiles() {
    return this.tiles;
  }

  /**
   * Gets the Tile at the given Coordinates
   * @param coordinates the position to get the Tile
   * @return the tile at the Coordinates
   */
  public Tile getTile(Coordinates coordinates) {
    return getTile(coordinates.x(), coordinates.y());
  }

  /**
   * Gets the Tile at the given position
   * @param x the horizontal position of the Tile
   * @param y the vertical position of the Tile
   * @return the tile at the position
   */
  public Tile getTile(int x, int y) {
    return this.tiles.get(x, y);
  }

  /**
   * Gets the List of Entity objects
   * @return entities
   */
  public List<Entity> getEntities() {
    return this.entities;
  }

  /**
   * Gets the unique id of this room
   * @return the id
   */
  public int getId() {
    return this.id;
  }

  /**
   * Renders the tiles and entities in the Room
   */
  public char[][] render() {
    int rows = this.tiles.rows();
    for (int r = 0; r < rows; r++) {
      // TODO cols
    }
    return null;
  }
}
