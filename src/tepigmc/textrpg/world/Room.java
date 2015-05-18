package tepigmc.textrpg.world;

import java.util.List;

import tepigmc.textrpg.TextRpg;
import tepigmc.util.GridArray;
import tepigmc.util.GridStorage;

public class Room {
  private GridStorage<Tile> tiles;
  private int id;

  /**
   * Constructs a Room with a Tile MatrixArray
   * @param tiles as a MatrixArray<Tile>
   */
  public Room(GridStorage<Tile> tiles) {
    this.tiles = tiles;
    this.id = TextRpg.nextRoomId;
    TextRpg.nextRoomId++;
  }

  /**
   * Constructs a Room with a Tile array
   * @param tiles as a Tile array
   */
  public Room(Tile[][] tiles) {
    this(new GridArray<Tile>(tiles));
  }

  /**
   * Constructs a Room with a Tile List
   * @param tiles as a Tile List
   */
  public Room(List<List<Tile>> tiles) {
    this(new GridArray<Tile>(tiles));
  }

  /**
   * Gets the tiles MatrixArray
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
   * Gets the unique id of this room
   * @return the id
   */
  public int getId() {
    return this.id;
  }
}
