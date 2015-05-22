package tepigmc.textrpg.world;

import java.util.List;

import tepigmc.textrpg.entity.Entity;
import tepigmc.textrpg.entity.Player;
import tepigmc.util.Grid;
import tepigmc.util.GridArray;

public class RoomRenderer {
  private Grid<Character> grid;
  private int rows;
  private int cols;

  /**
   * Creates a RoomRenderer for a Room with a Player in it
   * @param room the Room to render
   * @param player the Player to add
   */
  public RoomRenderer(Room room, Player player) {
    this(room);
    addEntity(player);
  }

  /**
   * Creates a RoomRenderer for a Room
   * @param room the Room to render
   */
  public RoomRenderer(Room room) {
    this(room.getTiles());
    addEntityList(room.getEntities());
  }

  /**
   * Creates a RoomRenderer with tiles in it
   * @param tiles the Tile Grid to render
   */
  public RoomRenderer(Grid<Tile> tiles) {
    this.grid = tilesToIcons(tiles);
    this.rows = tiles.rows();
    this.cols = tiles.cols();
  }

  /**
   * Creates a RoomRenderer with a given size
   * @param rows the amount of rows in the RoomRenderer
   * @param cols the amount of columns in the RoomRenderer
   */
  public RoomRenderer(int rows, int cols) {
    this.grid = new GridArray<Character>(rows, cols);
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Sets the icon at the given position to the given icon
   * @param row the row in the grid
   * @param col the column in the grid
   * @param icon a char to set in the grid
   */
  public void setIcon(int row, int col, Character icon) {
    this.grid.set(row, col, icon);
  }

  /**
   * Adds the entities to the grid
   * @param entities the Entity to add
   */
  public void addEntity(Entity entity) {
    Coordinates coordinates = entity.getCoordinates();
    setIcon(coordinates.y(), coordinates.x(), entity.getIcon());
  }

  /**
   * Adds all the entities in the List to the grid
   * @param entities the Entity objects to add
   */
  public void addEntityList(List<Entity> entities) {
    for (Entity entity : entities)
      addEntity(entity);
  }

  /**
   * Overlays a Tile Grid onto the RoomRendererer
   * @param row the row index
   * @param col the column index
   * @param tiles the Tile Grid to overlay
   * @param ignore a char to ignore when inserting the Tile Grid
   */
  public void overlayTiles(int row, int col, Grid<Tile> tiles, Character ignore) {
    canFit(col, col, tiles);
    int rows = tiles.rows(), cols = tiles.cols();
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++) {
        Character icon = tiles.get(r, c).getIcon();
        if (!(icon == null ? ignore == null : icon.equals(ignore)))
          setIcon(r, c, icon);
      }
  }

  /**
   * Overlays a Tile Grid onto the RoomRendererer
   * @param row the row index
   * @param col the column index
   * @param tiles the Tile Grid to overlay
   */
  public void overlayTiles(int row, int col, Grid<Tile> tiles) {
    overlayTiles(row, col, tiles, null);
  }

  /**
   * Throws an exception if the Tile Grid is too large to be inserted
   * @param row the row index
   * @param col the column index
   * @param tiles the Tile Grid to check
   */
  private void canFit(int row, int col, Grid<Tile> tiles) {
    int rows = tiles.rows(), cols = tiles.cols();
    if (row >= this.rows || row < 0 || col > this.cols || col < 0)
      throw new IndexOutOfBoundsException(
          "Position outside of Grid; (" + row + ", " + col + ")");
    if (row + rows > this.rows || col + cols > this.cols)
      throw new IllegalArgumentException(
          "Grid is larger than RoomRenderer");
  }

  /**
   * Converts a Tile Grid into a Character Grid of the icons
   * @param tiles the Tile Grid to convert
   * @return the converted Character Grid
   */
  public Grid<Character> tilesToIcons(Grid<Tile> tiles) {
    int rows = tiles.rows(), cols = tiles.cols();
    Grid<Character> icons = new GridArray<Character>(rows, cols);
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        icons.set(r, c, tiles.get(r, c).getIcon());
    return icons;
  }

  /**
   * Renders the grid as a multilined String with spaces for null items
   * @return the rendered grid
   */
  public String render() {
    return render(' ');
  }

  /**
   * Renders the grid as a multilined String
   * @param emptyChar the char to display instead of null items
   * @return the rendered grid
   */
  public String render(char emptyChar) {
    StringBuilder sb = new StringBuilder();
    int rows = this.grid.rows(), cols = this.grid.cols();
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        Character item = this.grid.get(r, c);
        if (item == null)
          item = emptyChar;
        sb.append(item);
      }
      if (r < rows - 1)
        sb.append('\n');
    }
    return sb.toString();
  }

  /**
   * Gets the grid
   */
  public Grid<Character> toGrid() {
    return this.grid;
  }

  /**
   * Creates a String representation of this object
   */
  public String toString() {
    return this.grid.toString();
  }
}
