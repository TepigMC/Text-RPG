package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.textrpg.tile.TileArray;
import tepigmc.util.SparseArray;

public class Room {
  private TileArray tiles;
  
  public Room(TileArray tiles) {
    this.tiles = tiles;
  }
  
  public Room(Tile[][] tiles) {
    this(new TileArray(tiles));
  }
  
  public Room(List<List<Tile>> tiles) {
    this(new TileArray(tiles));
  }
}
