package tepigmc.textrpg.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tepigmc.textrpg.entity.Entity;
import tepigmc.util.ArrayUtils;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;
import tepigmc.util.RandomUtils;

/**
 * A class used to create Room objects by using characters, then finalizing the
 * Room layout
 * @author Andrew Archibald
 */
public class RoomTemplate {
  private Grid<Character> grid;
  private Map<Character, Tile> tileMap;
  private List<Entity> entities;
  private List<Exit> exits;

  /**
   * Creates a RoomTemplate object with a given size
   * @param rows the amount of rows in the grid array
   * @param cols the amount of columns in the grid array
   */
  public RoomTemplate(int rows, int cols) {
    this(new GridArray<Character>(rows, cols), new HashMap<Character, Tile>(),
        new ArrayList<Entity>());
  }

  /**
   * Creates a RoomTemplate object with a given random size
   * @param minRows the minimum amount of rows in the grid array
   * @param maxRows the maximum amount of rows in the grid array
   * @param minCols the minimum amount of columns in the grid array
   * @param maxCols the maximum amount of columns in the grid array
   */
  public RoomTemplate(int minRows, int minCols, int maxRows, int maxCols) {
    this(RandomUtils.randInt(minRows, maxRows), RandomUtils.randInt(minCols, maxCols));
  }

  /**
   * Creates a RoomTemplate object with entities and exits
   * @param grid the grid of the room in a Grid
   * @param tileMap the corresponding Tile objects for each Character
   * @param entities a List of entities
   * @param exits a List of exits
   */
  public RoomTemplate(Grid<Character> grid,
      Map<Character, Tile> tileMap, List<Entity> entities, List<Exit> exits) {
    this.grid = grid;
    this.tileMap = tileMap;
    this.entities = entities;
    this.exits = exits;
  }

  /**
   * Creates a RoomTemplate object with entities
   * @param grid the grid of the room in a Grid
   * @param tileMap the corresponding Tile objects for each Character
   * @param entities a List of entities
   */
  public RoomTemplate(Grid<Character> grid,
      Map<Character, Tile> tileMap, List<Entity> entities) {
    this(grid, tileMap, entities, new ArrayList<Exit>());
  }

  /**
   * Creates a RoomTemplate object
   * @param grid the grid of the room in a Grid
   * @param tileMap the corresponding Tile objects for each Character
   */
  public RoomTemplate(Grid<Character> grid,
      Map<Character, Tile> tileMap) {
    this(grid, tileMap, new ArrayList<Entity>(), new ArrayList<Exit>());
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
    this(new GridArray<Character>(ArrayUtils.toCharacterArray2D(grid)), tileMap);
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
   * Gets the Character at the position in the grid
   * @param row the row position
   * @param col the column position
   * @return the Character at the position
   */
  public Character getCharacter(int row, int col) {
    if (this.grid == null)
      return null;
    return this.grid.get(row, col);
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
   * Gets the List of entities
   * @return the entities
   */
  public List<Entity> getEntities() {
    return this.entities;
  }

  /**
   * Gets the List of exits
   * @return the exits
   */
  public List<Exit> getExits() {
    return this.exits;
  }

  /**
   * Gets the height of the RoomTemplate
   * @return the number of rows in the Grid
   */
  public int rows() {
    return this.grid.rows();
  }

  /**
   * Gets the width of the RoomTemplate
   * @return the number of columns in the Grid
   */
  public int cols() {
    return this.grid.cols();
  }

  /**
   * Sets the grid to the given value
   * @return the previous grid
   */
  public Grid<Character> setGrid(Grid<Character> grid) {
    Grid<Character> previous = this.grid;
    if (grid == null)
      grid = new GridArray<Character>(0, 0);
    this.grid = grid;
    return previous;
  }

  /**
   * Set a char in the grid at a given position to the given key
   * @param row the row in the grid
   * @param col the column in the grid
   * @param key the char to be set in the grid
   * @return the previous item at that position
   */
  public Character setTile(int row, int col, Character key) {
    Character previous = getCharacter(row, col);
    if (this.grid == null)
      this.grid = new GridArray<Character>(0, 0);
    this.grid.set(row, col, key);
    return previous;
  }

  /**
   * Adds a key-value pair into the tileMap
   * @param key the key used in the grid
   * @param value the Tile used in the Room
   * @return the previous value associated with key
   */
  public Tile putKey(Character key, Tile value) {
    return this.tileMap.put(key, value);
  }

  /**
   * Adds an Entity to the Entity List
   * @param entity the Entity to add
   */
  public void addEntity(Entity entity) {
    this.entities.add(entity);
  }

  /**
   * Adds an Exit to the Exit List
   * @param exit the Exit to add
   */
  public void addExit(Exit exit) {
    this.exits.add(exit);
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
      for (int c = 0; c < cols; c++) {
        Character character = grid.get(r, c);
        Tile tile = tileMap.get(character);
        if (tile == null)
          tile = Tiles.empty;
        tiles[r][c] = tile;
      }
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
