package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.Map;

import tepigmc.util.ArrayUtils;
import tepigmc.util.GridArray;
import tepigmc.util.GridStorage;

public class RoomTemplate {
  private GridStorage<Character> template;
  private Map<Character, Tile> tileMap;

  /**
   * Creates a RoomTemplate object
   * @param template the template of the room in a GridStorage
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(GridStorage<Character> template,
      Map<Character, Tile> tileMap) {
    this.template = template;
    this.tileMap = tileMap;
  }

  /**
   * Creates a RoomTemplate object
   * @param template the template of the room in a 2D Character array
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(Character[][] template, Map<Character, Tile> tileMap) {
    this(new GridArray<Character>(template), tileMap);
  }

  /**
   * Creates a RoomTemplate object
   * @param template the template of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(char[][] template, Map<Character, Tile> tileMap) {
    this(new GridArray<Character>(charToCharacter(template)), tileMap);
  }

  /**
   * Creates a RoomTemplate object
   * @param template the template of the Room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   */
  public RoomTemplate(String[] template, Map<Character, Tile> tileMap) {
    this(ArrayUtils.toCharArray2D(template), tileMap);
  }

  /**
   * Creates a RoomTemplate object with a given size
   * @param rows the amount of rows in the template array
   * @param cols the amount of columns in the template array
   */
  public RoomTemplate(int rows, int cols) {
    this(new GridArray<Character>(rows, cols), new HashMap<Character, Tile>());
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room from the
   * template and tileMap in this
   * @return a GridArray to be used in a Room
   */
  public GridStorage<Tile> createTiles() {
    return createTiles(this.template, this.tileMap);
  }

  /**
   * Gets the template of the Room
   * @return the template
   */
  public GridStorage<Character> getTemplate() {
    return this.template;
  }

  /**
   * Gets the HashMap containing Tile objects that correspond to each Character
   * in the template
   * @return the tileMap
   */
  public Map<Character, Tile> getHashMap() {
    return this.tileMap;
  }

  /**
   * Set a char in the template at a given position to the given key
   * @param row the row in the template
   * @param col the column in the template
   * @param key the char to be set in the template
   * @return the previous item at that position
   */
  public void set(int row, int col, char key) {
    this.template.set(row, col, key);
  }

  /**
   * Adds a key-value pair into the tileMap
   * @param key the key used in the template
   * @param value the Tile used in the Room
   * @return the previous value associated with key
   */
  public Tile put(Character key, Tile value) {
    return this.tileMap.put(key, value);
  }

  /**
   * Creates a GridStorage of Tile objects that can be used in a Room
   * @param template the template of the room in a GridStorage of Character objects
   * @param tileMap the corresponding Tile objects for each Character
   * @return a GridStorage of Tile objects
   */
  public static GridStorage<Tile> createTiles(GridStorage<Character> template,
      Map<Character, Tile> tileMap) {
    // Fill the array with tiles corresponding to the characters
    int rows = template.rows(), cols = template.cols();
    Tile[][] tiles = new Tile[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++)
        tiles[r][c] = tileMap.get(template.get(r, c));
    }
    return new GridArray<Tile>(tiles);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param template the template of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   * @return a GridArray of Tile objects
   */
  public static GridStorage<Tile> createTiles(char[][] template,
      Map<Character, Tile> tileMap) {
    // Fill the array with tiles corresponding to the characters
    Tile[][] tiles = new Tile[template.length][template[0].length];
    for (int r = 0; r < template.length; r++) {
      char[] row = template[r];
      for (int c = 0; c < row.length; c++)
        tiles[r][c] = tileMap.get(row[c]);
    }
    return new GridArray<Tile>(tiles);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param template the template of the room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   * @return a GridArray of Tile objects
   */
  public static GridStorage<Tile> createTiles(String[] template,
      Map<Character, Tile> tileMap) {
    return createTiles(ArrayUtils.toCharArray2D(template), tileMap);
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
