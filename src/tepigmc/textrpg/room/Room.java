package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.RectangleArray;

public class Room {
  private RectangleArray<Tile> tiles;
  
  /**
   * Constructs a Room with a Tile MatrixArray
   * @param tiles as a MatrixArray<Tile>
   */
  public Room(RectangleArray<Tile> tiles) {
    this.tiles = tiles;
  }
  
  /**
   * Constructs a Room with a Tile array
   * @param tiles as a Tile array
   */
  public Room(Tile[][] tiles) {
    this(new RectangleArray<Tile>(tiles));
  }
  
  /**
   * Constructs a Room with a Tile List
   * @param tiles as a Tile List
   */
  public Room(List<List<Tile>> tiles) {
    this(new RectangleArray<Tile>(tiles));
  }
  
  /**
   * Gets the tiles MatrixArray
   * @return tiles
   */
  public RectangleArray<Tile> getTiles() {
    return this.tiles;
  }
}
