package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.textrpg.util.SparseArray;

public class Room {
  private SparseArray<Tile> tiles;
  
  public Room(SparseArray<Tile> tiles) {
    this.tiles = tiles;
  }
  
  public Room(Tile[][] tiles) {
    this(new SparseArray<Tile>(tiles));
  }
  
  public Room(List<List<Tile>> tiles) {
    this(new SparseArray<Tile>(tiles));
  }
}
