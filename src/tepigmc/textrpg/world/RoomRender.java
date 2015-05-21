package tepigmc.textrpg.world;

import java.util.List;

import tepigmc.textrpg.entity.Entity;
import tepigmc.util.Grid;

public class RoomRender {
  private Grid<Character> grid;

  // TODO rendering
  
  public RoomRender(Grid<Tile> tiles) {
    this.grid = renderTiles(tiles);
  }

  /**
   * Sets the icon at the given position to the given icon
   * @param row the row in the grid
   * @param col the column in the grid
   * @param icon a char to set in the grid
   */
  public void setIcon(int row, int col, char icon) {
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
  
  public Grid<Character> renderTiles(Grid<Tile> tiles) {
    // TODO renderTiles()
    return null;
  }
  
  /**
   * Renders the grid as a multilined String
   * @return the rendered grid
   */
  public String render() {
    // TODO render
    return "";
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
