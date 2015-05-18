package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.Map;

import tepigmc.util.ArrayUtils;
import tepigmc.util.GridArray;
import tepigmc.util.GridStorage;

public class RoomTemplate {
  private GridStorage<Character> layout;
  private Map<Character, Tile> tileMap;

  /**
   * Creates a RoomTemplate object
   * @param layout the layout of the room in a GridStorage
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(GridStorage<Character> layout,
      Map<Character, Tile> tileMap) {
    this.layout = layout;
    this.tileMap = tileMap;
  }

  /**
   * Creates a RoomTemplate object
   * @param layout the layout of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(char[][] layout, Map<Character, Tile> tileMap) {
    this(new GridArray<Character>(charToCharacter(layout)), tileMap);
  }

  /**
   * Creates a RoomTemplate object
   * @param layout the layout of the Room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   */
  public RoomTemplate(String[] layout, Map<Character, Tile> tileMap) {
    this(ArrayUtils.toCharArray(layout), tileMap);
  }

  /**
   * Creates a RoomTemplate object with a given size
   * @param rows the amount of rows in the layout array
   * @param cols the amount of columns in the layout array
   */
  public RoomTemplate(int rows, int cols) {
    this(new GridArray<Character>(rows, cols), new HashMap<Character, Tile>());
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room from the
   * layout and tileMap in this
   * @return a GridArray to be used in a Room
   */
  public GridStorage<Tile> createTiles() {
    return createTiles(this.layout, this.tileMap);
  }

  /**
   * Gets the 2D char layout of the Room
   * @return the layout
   */
  public GridStorage<Character> getLayout() {
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
    return this.layout.set(row, col, key);
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
   * Creates a GridStorage of Tile objects that can be used in a Room
   * @param layout the layout of the room in a GridStorage of Character objects
   * @param tileMap the corresponding Tile objects for each Character
   * @return a GridStorage of Tile objects
   */
  public static GridStorage<Tile> createTiles(GridStorage<Character> layout,
      Map<Character, Tile> tileMap) {
    // Fill the array with tiles corresponding to the characters
    Tile[][] tiles = new Tile[layout.rows()][layout.cols()];
    for (int r = 0; r < layout.rows(); r++) {
      for (int c = 0; c < layout.cols(); c++)
        tiles[r][c] = tileMap.get(layout.get(r, c));
    }
    return new GridArray<Tile>(tiles);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param layout the layout of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   * @return a GridArray of Tile objects
   */
  public static GridStorage<Tile> createTiles(char[][] layout,
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
  public static GridStorage<Tile> createTiles(String[] layout,
      Map<Character, Tile> tileMap) {
    return createTiles(ArrayUtils.toCharArray(layout), tileMap);
  }

  /**
   * Converts a char 2D array to a Character 2D array
   * @param charArray the char 2D array to convert
   * @return the resulting Character 2D array
   */
  private static Character[][] charToCharacter(char[][] charArray) {
    int rows = charArray.length, cols = charArray[0].length;
    Character[][] characterArray = new Character[rows][cols];
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        characterArray[r][c] = charArray[r][c];
    return characterArray;
  }
}
