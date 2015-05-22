package tepigmc.textrpg.world;

import java.util.HashMap;
import java.util.Map;

import tepigmc.util.ArrayUtils;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;
import tepigmc.util.RandomUtils;

public class RoomTemplate {
  private Grid<Character> grid;
  private Map<Character, Tile> tileMap;

  /**
   * Creates a RoomTemplate object
   * @param grid the grid of the room in a Grid
   * @param tileMap the corresponding Tile objects for each Character
   */
  @Deprecated
  public RoomTemplate(Grid<Character> grid,
      Map<Character, Tile> tileMap) {
    this.grid = grid;
    this.tileMap = tileMap;
  }

  /**
   * Creates a RoomTemplate object
   * @param grid the grid of the room in a 2D Character array
   * @param tileMap the corresponding Tile objects for each Character
   */
  @Deprecated
  public RoomTemplate(Character[][] grid, Map<Character, Tile> tileMap) {
    this(new GridArray<Character>(grid), tileMap);
  }

  /**
   * Creates a RoomTemplate object
   * @param grid the grid of the room in a 2D char array
   * @param tileMap the corresponding Tile objects for each Character
   */
  @Deprecated
  public RoomTemplate(char[][] grid, Map<Character, Tile> tileMap) {
    this(new GridArray<Character>(charToCharacter(grid)), tileMap);
  }

  /**
   * Creates a RoomTemplate object
   * @param grid the grid of the Room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   */
  @Deprecated
  public RoomTemplate(String[] grid, Map<Character, Tile> tileMap) {
    this(ArrayUtils.toCharArray2D(grid), tileMap);
  }

  /**
   * Creates a RoomTemplate object with a given size
   * @param rows the amount of rows in the grid array
   * @param cols the amount of columns in the grid array
   */
  public RoomTemplate(int rows, int cols) {
    this(new GridArray<Character>(rows, cols), new HashMap<Character, Tile>());
  }

  /**
   * Creates a RoomTemplate object with a given random size
   * @param minRows the minimum amount of rows in the grid array
   * @param minRows the maximum amount of rows in the grid array
   * @param minCols the minimum amount of columns in the grid array
   * @param maxCols the maximum amount of columns in the grid array
   */
  public RoomTemplate(int minRows, int maxRows, int minCols, int maxCols) {
    this(RandomUtils.randInt(minRows, maxRows), RandomUtils.randInt(minCols, maxCols));
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room from the
   * grid and tileMap in this
   * @return a GridArray to be used in a Room
   */
  public Grid<Tile> createTiles() {
    return createTiles(this.grid, this.tileMap);
  }

  /**
   * Gets the grid of the Room
   * @return the grid
   */
  public Grid<Character> getGrid() {
    return this.grid;
  }

  /**
   * Gets the HashMap containing Tile objects that correspond to each Character
   * in the grid
   * @return the tileMap
   */
  public Map<Character, Tile> getHashMap() {
    return this.tileMap;
  }

  /**
   * Set a char in the grid at a given position to the given key
   * @param row the row in the grid
   * @param col the column in the grid
   * @param key the char to be set in the grid
   * @return the previous item at that position
   */
  public void set(int row, int col, char key) {
    this.grid.set(row, col, key);
  }

  /**
   * Adds a key-value pair into the tileMap
   * @param key the key used in the grid
   * @param value the Tile used in the Room
   * @return the previous value associated with key
   */
  public Tile put(Character key, Tile value) {
    return this.tileMap.put(key, value);
  }

  /**
   * Creates a Grid of Tile objects that can be used in a Room
   * @param grid the grid of the room in a Grid of Character objects
   * @param tileMap the corresponding Tile objects for each Character
   * @return a Grid of Tile objects
   */
  public static Grid<Tile> createTiles(Grid<Character> grid,
      Map<Character, Tile> tileMap) {
    int rows = grid.rows(), cols = grid.cols();
    Tile[][] tiles = new Tile[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++)
        tiles[r][c] = tileMap.get(grid.get(r, c));
    }
    return new GridArray<Tile>(tiles);
  }

  /**
   * Creates a GridArray of Tile objects that can be used in a Room
   * @param grid the grid of the room in a String array
   * @param tileMap the corresponding Tile objects for each Character in the
   *          String array
   * @return a GridArray of Tile objects
   */
  public static Grid<Tile> createTiles(String[] characters,
      Map<Character, Tile> tileMap) {
    return createTiles(
        new GridArray<Character>(ArrayUtils.toCharacterArray2D(characters)), tileMap);
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
