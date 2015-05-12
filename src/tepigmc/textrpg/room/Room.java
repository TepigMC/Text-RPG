package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.MatrixArray;

public class Room {
  private MatrixArray<Tile> tiles;
  
  public Room(MatrixArray<Tile> tiles) {
    this.tiles = tiles;
  }
  
  public Room(Tile[][] tiles) {
    this(new MatrixArray<Tile>(tiles));
  }
  
  public Room(List<List<Tile>> tiles) {
    this(new MatrixArray<Tile>(tiles));
  }
  
  public MatrixArray<Tile> getTiles() { return this.tiles; }
}
