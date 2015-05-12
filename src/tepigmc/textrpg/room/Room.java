package tepigmc.textrpg.room;

import java.util.List;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.RectangleList;

public class Room {
  private RectangleList<Tile> tiles;
  
  public Room(RectangleList<Tile> tiles) {
    this.tiles = tiles;
  }
  
  public Room(Tile[][] tiles) {
    this(new RectangleList<Tile>(tiles));
  }
  
  public Room(List<List<Tile>> tiles) {
    this(new RectangleList<Tile>(tiles));
  }
  
  public RectangleList<Tile> getTiles() { return this.tiles; }
}
