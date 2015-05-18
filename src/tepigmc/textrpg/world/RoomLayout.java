package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.Map;

import tepigmc.util.ArrayUtils;
import tepigmc.util.GridArray;

public class RoomLayout {
  private char[][] layout;
  private Map<Character, Tile> tileMap;

  /**
   * Creates a RoomLayout object
   * @param layout the layout of the room as a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomLayout(char[][] layout, Map<Character, Tile> tileMap) {
    this.layout = layout;
    this.tileMap = tileMap;
  }

  /**
   * Creates a RoomLayout object
   * @param layout the layout of the Room as a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   */
  public RoomLayout(String[] layout, Map<Character, Tile> tileMap) {
    this(ArrayUtils.toCharArray(layout), tileMap);
  }
  
  /**
   * Creates a RoomLayout object with a given size
   * @param width the amount of columns in the layout array
   * @param height the amount of rows in the layout array
   */
  public RoomLayout(int width, int height) {
    this(new char[height][width], new HashMap<Character, Tile>());
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room from the
   * layout and tileMap in this
   * @return a GridArray to be used in a Room
   */
  public GridArray<Tile> createTiles() {
    return createTiles(this.layout, this.tileMap);
  }

  /**
   * Gets the 2D char layout of the Room
   * @return the layout
   */
  public char[][] getLayout() {
    return this.layout;
  }

  /**
   * Gets the HashMap containing Tile objects that correspond to each Character
   * in the layout
   * @return the tileMap
   */
  public Map<Character, Tile> getHashMap() {
    return this.tileMap;
  }
  
  /**
   * Set a char in the layout at a given position to the given key
   * @param row the row in the layout
   * @param col the column in the layout
   * @param key the char to be set in the layout
   * @return the previous item at that position
   */
  public char set(int row, int col, char key) {
    char previous = this.layout[row][col];
    this.layout[row][col] = key;
    return previous;
  }
  
  /**
   * Adds a key-value pair into the tileMap
   * @param key the key used in the layout
   * @param value the Tile used in the Room
   * @return the previous value associated with key
   */
  public Tile put(Character key, Tile value) {
    return this.tileMap.put(key, value);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   * @return a GridArray of Tile objects
   */
  public static GridArray<Tile> createTiles(char[][] layout,
      Map<Character, Tile> tileMap) {
    // Fill the array with tiles corresponding to the characters
    Tile[][] tiles = new Tile[layout.length][layout[0].length];
    for (int r = 0; r < layout.length; r++) {
      char[] row = layout[r];
      for (int c = 0; c < row.length; c++)
        tiles[r][c] = tileMap.get(row[c]);
    }
    return new GridArray<Tile>(tiles);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   * @return a GridArray of Tile objects
   */
  public static GridArray<Tile> createTiles(String[] layout,
      Map<Character, Tile> tileMap) {
    return createTiles(ArrayUtils.toCharArray(layout), tileMap);
  }
}
