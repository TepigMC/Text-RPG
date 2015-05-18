package tepigmc.textrpg.world;

import java.util.List;

import tepigmc.textrpg.entity.Entity;
import tepigmc.util.GridStorage;

public class RoomRender {
  private GridStorage<Character> map;

  //TODO lots of stuff
  
  public RoomRender(GridStorage<Character> map) {
    this.map = map;
  }

  /**
   * Sets the icon at the given position to the given icon
   * @param row the row in the map
   * @param col the column in the map
   * @param icon a char to set in the map
   */
  public void setIcon(int row, int col, char icon) {
    this.map.set(row, col, icon);
  }

  /**
   * Adds the entities to the map
   * @param entities the Entity to add
   */
  public void addEntity(Entity entity) {
    Coordinates coordinates = entity.getCoordinates();
    setIcon(coordinates.y(), coordinates.x(), entity.getIcon());
  }

  /**
   * Adds all the entities in the List to the map
   * @param entities the Entity objects to add
   */
  public void addEntityList(List<Entity> entities) {
    for (Entity entity : entities)
      addEntity(entity);
  }
}
