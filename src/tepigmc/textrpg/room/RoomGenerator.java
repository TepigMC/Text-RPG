package tepigmc.textrpg.room;

import java.util.HashMap;

import tepigmc.textrpg.tile.Tile;
import tepigmc.util.GridArray;

public class RoomGenerator {
  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in Character objects
   * @param hashMap the corresponding Tile objects for each Character
   * @return a GridArray of Tile objects
   */
  public static GridArray<Tile> createTiles(String[] layout,
      HashMap<Character, Tile> hashMap) {
    // Calculate the width the room will be
    int mapWidth = 0;
    int mapHeight = layout.length;
    for (String row : layout) {
      int length = row.length();
      if (mapWidth < length) {
        mapWidth = length;
      }
    }
    // Fill the array with tiles corresponding to the Characters
    Tile[][] tileMap = new Tile[mapHeight][mapWidth];
    for (int r = 0; r < mapHeight; r++) {
      String row = layout[r];
      for (int c = 0; c < row.length(); c++) {
        tileMap[r][c] = hashMap.get(row.charAt(c));
      }
    }
    return new GridArray<Tile>(tileMap);
  }
}