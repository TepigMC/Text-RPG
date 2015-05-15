package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.GridArray;
import tepigmc.util.GridStorage;

public class Room {
  private GridStorage<Tile> tiles;

  /**
   * Constructs a Room with a Tile MatrixArray
   * @param tiles as a MatrixArray<Tile>
   */
  public Room(GridStorage<Tile> tiles) {
    this.tiles = tiles;
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
}
