package tepigmc.textrpg.world;

import java.util.HashMap;

import tepigmc.util.ArrayUtils;
import tepigmc.util.GridArray;

public class RoomLayout {
  private char[][] layout;
  private HashMap<Character, Tile> hashMap;

  // TODO docs
  public RoomLayout(char[][] layout, HashMap<Character, Tile> hashMap) {
    this.layout = layout;
    this.hashMap = hashMap;
  }

  public RoomLayout(String[] layout, HashMap<Character, Tile> hashMap) {
    this(ArrayUtils.toCharArray(layout), hashMap);
  }

  public GridArray<Tile> createTiles() {
    return createTiles(this.layout, this.hashMap);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in a String array
   * @param hashMap the corresponding Tile objects for each Character in the
   *          String array
   * @return a GridArray of Tile objects
   */
  public static GridArray<Tile> createTiles(char[][] layout,
      HashMap<Character, Tile> hashMap) {
    // Fill the array with tiles corresponding to the characters
    Tile[][] tileMap = new Tile[layout.length][layout[0].length];
    for (int r = 0; r < layout.length; r++) {
      char[] row = layout[r];
      for (int c = 0; c < row.length; c++)
        tileMap[r][c] = hashMap.get(row[c]);
    }
    return new GridArray<Tile>(tileMap);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in a 2D char array
   * @param hashMap the corresponding Tile objects for each Character
   * @return a GridArray of Tile objects
   */
  public static GridArray<Tile> createTiles(String[] layout,
      HashMap<Character, Tile> hashMap) {
    return createTiles(ArrayUtils.toCharArray(layout), hashMap);
  }
}
