package tepigmc.textrpg.tile;

import java.util.ArrayList;
import java.util.List;

public class TileArray {
  private List<List<Tile>> tiles;
  
  public TileArray(Tile[][] tiles) {
    
  }
  
  public TileArray(List<List<Tile>> tiles) {
    this.tiles = tiles;
  }
}
