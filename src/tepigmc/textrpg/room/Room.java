package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.MatrixArray;

public class Room {
  private MatrixArray<Tile> tiles;
  
  /**
   * Constructs a Room with a Tile MatrixArray
   * @param tiles as a MatrixArray<Tile>
   */
  public Room(MatrixArray<Tile> tiles) {
    this.tiles = tiles;
  }
  
  /**
   * Constructs a Room with a Tile array
   * @param tiles as a Tile array
   */
  public Room(Tile[][] tiles) {
    this(new MatrixArray<Tile>(tiles));
  }
  
  /**
   * Constructs a Room with a Tile List
   * @param tiles as a Tile List
   */
  public Room(List<List<Tile>> tiles) {
    this(new MatrixArray<Tile>(tiles));
  }
  
  /**
   * Gets the tiles MatrixArray
   * @return tiles
   */
  public MatrixArray<Tile> getTiles() {
    return this.tiles;
  }
}
